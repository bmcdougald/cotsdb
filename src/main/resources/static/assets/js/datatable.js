$(document).ready(function () {

        // Setup - add a text input to each footer cell
        $('#productTable thead tr')
            .clone(true)
            .addClass('filters')
            .appendTo('#productTable thead');

        var table = $('#productTable').DataTable({
            dom:  "<'row'<'col-md-12' B>>" +
                  "<'row'<'col-md-6'l><'col-md-6'f>>" +
                  "<'row'<'col-md-12't>><'row'<'col-md-12'ip>>",
            lengthChange: true,
            lengthMenu: [ [ 10, 25, 50, -1 ], [ '10 rows', '25 rows', '50 rows', 'Show all' ] ],
            buttons: [
//              'pageLength',  --This produces an empty picklist???
              'excelHtml5',
              'csvHtml5',
              'pdfHtml5',
              'print'
            ],
            orderCellsTop: true,
            fixedHeader: true,
            initComplete: function () {
                var api = this.api();


                // For each column
                api
                    .columns()
                    .eq(0)
                    .each(function (colIdx) {
                        // Set the header cell to contain the input element
                        var cell = $('.filters th').eq(
                            $(api.column(colIdx).header()).index()
                        );
                        var title = $(cell).text();
                        $(cell).html('<input type="text" placeholder="' + title + '" />');

                        // On every keypress in this input
                        $(
                            'input',
                            $('.filters th').eq($(api.column(colIdx).header()).index())
                        )
                            .off('keyup change')
                            .on('change', function (e) {
                                // Get the search value
                                $(this).attr('title', $(this).val());
                                var regexr = '({search})'; //$(this).parents('th').find('select').val();

                                var cursorPosition = this.selectionStart;
                                // Search the column for that value
                                api
                                    .column(colIdx)
                                    .search(
                                        this.value != ''
                                            ? regexr.replace('{search}', '(((' + this.value + ')))')
                                            : '',
                                        this.value != '',
                                        this.value == ''
                                    )
                                    .draw();
                            })
                            .on('keyup', function (e) {
                                e.stopPropagation();

                                $(this).trigger('change');
                                $(this)
                                    .focus()[0]
                                    .setSelectionRange(cursorPosition, cursorPosition);
                            });
                    });
            },
        });
//        table.buttons().container()
//                .appendTo( '#productTable_wrapper .col-md-6:eq(0)' );
    });