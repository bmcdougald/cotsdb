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

  /** Product Name */
  @NotBlank
  private String product_name;

  /** Version Number */
  @Column(columnDefinition = "text")
  private String version;

  /** License Key */
  @Column(columnDefinition = "text")
  private String license_key;

  /** License Start Date */
  @Column(columnDefinition = "date")
  private String start_date;

  /** License Expiration Date */
  @Column(columnDefinition = "date")
  private String expiration_date;

}
