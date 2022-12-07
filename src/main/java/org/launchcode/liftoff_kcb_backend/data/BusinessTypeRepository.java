package org.launchcode.liftoff_kcb_backend.data;

import org.launchcode.liftoff_kcb_backend.models.BusinessType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessTypeRepository extends CrudRepository<BusinessType, Integer> {
}
