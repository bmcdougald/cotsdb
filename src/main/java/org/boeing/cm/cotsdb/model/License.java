package org.boeing.cm.cotsdb.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.ZonedDateTime;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

/**
 * License Class.
 */
@Entity
@Table(name = "license" , schema = "public")
@Data
public class License {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  /** Environment */
  @NotBlank
  private String environment;

  /** Product Name */
  @NotBlank
  private String product_name;

  /** Version Number */
  @Column(columnDefinition = "text")
  private String version;

  /** Vendor */
  @NotBlank
  private String vendor;

  /** License Key */
  @Column(columnDefinition = "text")
  private String license_key;

  /** License Start Date */
  @Column(columnDefinition = "date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date start_date;

  /** License Expiration Date */
  @Column(columnDefinition = "date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date expiration_date;

  /** Equipment its hosted on */
  @Column(columnDefinition = "text")
  private String equipment;

  /** Media Type */
  @Column(columnDefinition = "text")
  private String media_type;

  /** PO Number */
  @Column(columnDefinition = "text")
  private String po_number;

//  /** Access Migration */
//  @Column(columnDefinition = "access_migration")
//  private boolean access_migration;

}
