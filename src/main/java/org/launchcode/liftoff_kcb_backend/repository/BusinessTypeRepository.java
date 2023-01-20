package org.launchcode.liftoff_kcb_backend.repository;

import org.launchcode.liftoff_kcb_backend.model.BusinessType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BusinessTypeRepository extends CrudRepository<BusinessType, Long> {
    Optional<BusinessType> findByName(String name);
}
