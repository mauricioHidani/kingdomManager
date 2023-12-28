package com.kingdom.manager.infrastructure.address.factories;

import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.infrastructure.address.persists.entities.AddressTypeEntity;

public class AddressTypeFactory  {
    public static AddressType newModel() {
        return new AddressType(
                null,
                "legal",
                "this is a description of a address type legal"
        );
    }

    public static AddressType newModel(Integer id) {
        return new AddressType(
                id,
                "legal",
                "this is a description of a address type legal"
        );
    }

    public static AddressTypeEntity newEntity() {
        return new AddressTypeEntity(
                null,
                "legal",
                "this is a description of a address type legal"
        );
    }

    public static AddressTypeEntity newEntity(Integer id) {
        return new AddressTypeEntity(
                id,
                "legal",
                "this is a description of a address type legal"
        );
    }

    public static AddressTypeInput newInput() {
        return new AddressTypeInput(
                "legal",
                "this is a description of a address type legal"
        );
    }
}
