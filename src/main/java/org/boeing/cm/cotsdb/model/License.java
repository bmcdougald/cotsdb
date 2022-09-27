package org.boeing.cm.cotsdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;

import lombok.Data;

/**
 * License Class.
 */
@Entity
@Table(name = "license" , schema = "public")
@Data
public class License {

  /** Sequence Name */
  private static final String SEQUENCE_NAME = "customer_id_seq";

  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
  private Long id;

  /** Product Name */
  @NotBlank
  private String product_name;

  @Column(columnDefinition = "text")
  private String version;
}
