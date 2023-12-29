package com.kingdom.manager.application.address.out;

import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;

public record AddressTypeOutput(
        String title,
        String description
) {
    public static AddressType toModel(AddressTypeOutput output) {
        if (output == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type output model being null"
            );
        }

        return new AddressType(
                null,
                output.title(),
                output.description()
        );
    }

    public static AddressType toModel(Integer id, AddressTypeOutput output) {
        if (id == null || id < 1 || output == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type output model being null or with its null id"
            );
        }

        return new AddressType(
                id,
                output.title(),
                output.description()
        );
    }

    public static AddressTypeInput toInput(AddressTypeOutput output) {
        if (output == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type output model being null"
            );
        }

        return new AddressTypeInput(
                output.title(),
                output.description()
        );
    }

    public static AddressTypeOutput from(AddressType model) {
        if (model == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type model being null"
            );
        }

        return new AddressTypeOutput(
                model.title(),
                model.description()
        );
    }
}
