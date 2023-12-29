package com.kingdom.manager.infrastructure.address.persists.repositories;

import com.kingdom.manager.infrastructure.address.persists.entities.AddressTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAddressTypeRepository extends JpaRepository<AddressTypeEntity, Integer> {
    AddressTypeEntity findByTitle(String title);
}
