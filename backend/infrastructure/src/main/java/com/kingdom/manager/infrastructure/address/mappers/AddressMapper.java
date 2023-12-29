package com.kingdom.manager.infrastructure.address.mappers;

import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.infrastructure.address.persists.entities.AddressEntity;
import com.kingdom.manager.infrastructure.address.persists.entities.AddressTypeEntity;
import com.kingdom.manager.infrastructure.address.persists.entities.PersonEntity;

import java.util.Optional;

public class AddressMapper {
    public static AddressEntity toEntity(Address model) {
        if (model == null) {
            throw new InvalidArgumentException(
                    "Could not convert address model being null"
            );
        }
        return new AddressEntity(
                model.id(),
                model.types(),
                model.publicPlace(),
                model.number(),
                model.complement(),
                model.neighborhood(),
                model.city(),
                model.state(),
                model.country(),
                model.zipcode(),
                model.register(),
                new PersonEntity(model.ownerId(), null, null)
        );
    }

    public static Address toModel(AddressEntity entity) {
        if (entity == null) {
            throw new InvalidArgumentException(
                    "Could not convert address entity being null"
            );
        }
        return new Address(
                entity.getId(),
                entity.getTypes(),
                entity.getPublicPlace(),
                entity.getNumber(),
                entity.getComplement(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getCountry(),
                entity.getZipcode(),
                entity.getRegister(),
                entity.getOwner().getId()
        );
    }

    public static Optional<Address> toModel(Optional<AddressEntity> entityOptional) {
        if (entityOptional.isEmpty()) {
            throw new InvalidArgumentException(
                    "Could not convert address entity being null"
            );
        }
        var entity = entityOptional.get();
        return Optional.of(new Address(
                entity.getId(),
                entity.getTypes(),
                entity.getPublicPlace(),
                entity.getNumber(),
                entity.getComplement(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getCountry(),
                entity.getZipcode(),
                entity.getRegister(),
                entity.getOwner().getId()
        ));
    }
}
