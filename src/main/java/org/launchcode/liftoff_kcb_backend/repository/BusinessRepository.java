package org.launchcode.liftoff_kcb_backend.repository;

import org.launchcode.liftoff_kcb_backend.model.Business;
import org.launchcode.liftoff_kcb_backend.model.BusinessDetails;
import org.launchcode.liftoff_kcb_backend.model.BusinessType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BusinessRepository extends CrudRepository<Business, Long> {
    Optional<Business> findByName(String name);
    List<Business> findByOwnerId(Long ownerId);

}
