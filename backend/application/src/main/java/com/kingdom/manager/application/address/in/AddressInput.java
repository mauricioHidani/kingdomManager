package com.kingdom.manager.application.address.in;

import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record AddressInput(
        UUID id,
        Set<AddressTypeInput> types,
        String publicPlace,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country,
        String zipcode,
        LocalDate register,
        UUID ownerId
) {
    public static Address toModel(AddressInput input) {
        if (input == null) {
            throw new InvalidArgumentException(
                    "Could not convert address input model being null"
            );
        }

        return new Address(
                input.id(),
                input.types().stream().map(AddressTypeInput::toModel).collect(Collectors.toSet()),
                input.publicPlace(),
                input.number(),
                input.complement(),
                input.neighborhood(),
                input.city(),
                input.state(),
                input.country(),
                input.zipcode(),
                input.register(),
                input.ownerId()
        );
    }

    public static Address toModel(UUID id, AddressInput input) {
        if (id == null || input == null) {
            throw new InvalidArgumentException(
                    "Could not convert address input model being null or with its null id"
            );
        }

        return new Address(
                id,
                input.types().stream().map(AddressTypeInput::toModel).collect(Collectors.toSet()),
                input.publicPlace(),
                input.number(),
                input.complement(),
                input.neighborhood(),
                input.city(),
                input.state(),
                input.country(),
                input.zipcode(),
                input.register(),
                input.ownerId()
        );
    }

    public static AddressOutput toOutput(AddressInput input) {
        if (input == null) {
            throw new InvalidArgumentException(
                    "Could not convert address input model being null"
            );
        }

        return new AddressOutput(
                input.id() == null ? null : input.id().toString(),
                input.types().stream().map(AddressTypeInput::toOutput).collect(Collectors.toSet()),
                input.publicPlace(),
                input.number(),
                input.complement(),
                input.neighborhood(),
                input.city(),
                input.state(),
                input.country(),
                input.zipcode(),
                input.register().toString(),
                input.ownerId().toString()
        );
    }

    public static AddressInput from(Address model) {
        if (model == null) {
            throw new InvalidArgumentException(
                    "Could not convert address model being null"
            );
        }

        return new AddressInput(
                model.id(),
                model.types().stream().map(AddressTypeInput::from).collect(Collectors.toSet()),
                model.publicPlace(),
                model.number(),
                model.complement(),
                model.neighborhood(),
                model.city(),
                model.state(),
                model.country(),
                model.zipcode(),
                model.register(),
                model.ownerId()
        );
    }
}
