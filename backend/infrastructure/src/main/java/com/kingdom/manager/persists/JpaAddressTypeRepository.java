package com.kingdom.manager.persists;

import com.kingdom.manager.entities.AddressTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAddressTypeRepository extends JpaRepository<AddressTypeEntity, Integer> {
    AddressTypeEntity findByTitle(String title);
}
