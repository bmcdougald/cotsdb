package org.boeing.cm.cotsdb.repository;

import org.boeing.cm.cotsdb.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * License Repository Class.
 */
public interface LicenseRepository extends JpaRepository<License, Long> {

}
