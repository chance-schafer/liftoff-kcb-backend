package org.launchcode.liftoff_kcb_backend.repository;

import org.launchcode.liftoff_kcb_backend.model.OwnerType;

import java.util.Optional;

public interface OwnerTypeRepository {
    Optional<OwnerType> findByName(String name);
}
