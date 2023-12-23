package com.kingdom.manager.application.address.in;

import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;

public record AddressTypeInput(
        String title,
        String description
) {
    public static AddressType toModel(AddressTypeInput input) {
        if (input == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type input model being null"
            );
        }

        return new AddressType(
                null,
                input.title(),
                input.description()
        );
    }

    public static AddressType toModel(Integer id, AddressTypeInput input) {
        if (id == null || id < 1 || input == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type input model being null or with its null id"
            );
        }

        return new AddressType(
                id,
                input.title(),
                input.description()
        );
    }

    public static AddressTypeOutput toOutput(AddressTypeInput input) {
        if (input == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type input model being null"
            );
        }

        return new AddressTypeOutput(
                input.title(),
                input.description()
        );
    }

    public static AddressTypeInput from(AddressType model) {
        if (model == null) {
            throw new InvalidArgumentException(
                    "Could not convert address type model being null"
            );
        }

        return new AddressTypeInput(
                model.title(),
                model.description()
        );
    }
}
