package com.kingdom.manager.infrastructure.address.persists.repositories;

import com.kingdom.manager.infrastructure.address.persists.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaAddressRepository extends JpaRepository<AddressEntity, UUID> {
}
