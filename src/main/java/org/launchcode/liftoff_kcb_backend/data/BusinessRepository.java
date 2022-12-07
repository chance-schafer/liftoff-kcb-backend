package org.launchcode.liftoff_kcb_backend.data;

import org.launchcode.liftoff_kcb_backend.models.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Integer> {
}
