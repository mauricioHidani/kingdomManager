package com.kingdom.manager.infrastructure.address.mappers;

import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.infrastructure.address.persists.entities.AddressTypeEntity;

import java.util.Optional;

public class AddressTypeMapper {
    public static AddressTypeEntity toEntity(AddressType model) {
        if (model == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type model being null"
            );
        }
        return new AddressTypeEntity(
                model.id(),
                model.title(),
                model.description()
        );
    }

    public static AddressType toModel(AddressTypeEntity entity) {
        if (entity == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type entity being null"
            );
        }
        return new AddressType(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription()
        );
    }

    public static Optional<AddressType> toModel(Optional<AddressTypeEntity> entityOptional) {
        if (entityOptional.isEmpty()) {
            throw new InvalidArgumentException(
                    "Could not convert address type entity being null"
            );
        }
        var entity = entityOptional.get();
        return Optional.of(new AddressType(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription()
        ));
    }
}
