package com.kingdom.manager.application.address.out;

import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record AddressOutput(
        String id,
        Set<AddressTypeOutput> types,
        String publicPlace,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country,
        String zipcode,
        String register,
        String ownerId
) {
    public static Address toModel(AddressOutput output) {
        if (output == null) {
            throw new InvalidArgumentException(
                    "Could not convert address output model being null"
            );
        }

        return new Address(
                UUID.fromString(output.id()),
                output.types().stream().map(AddressTypeOutput::toModel).collect(Collectors.toSet()),
                output.publicPlace(),
                output.number(),
                output.complement(),
                output.neighborhood(),
                output.city(),
                output.state(),
                output.country(),
                output.zipcode(),
                LocalDate.parse(output.register()),
                UUID.fromString(output.ownerId())
        );
    }

    public static Address toModel(UUID id, AddressOutput output) {
        if (id == null || output == null) {
            throw new InvalidArgumentException(
                    "Could not convert address output model being null or with its null id"
            );
        }

        return new Address(
                id,
                output.types().stream().map(AddressTypeOutput::toModel).collect(Collectors.toSet()),
                output.publicPlace(),
                output.number(),
                output.complement(),
                output.neighborhood(),
                output.city(),
                output.state(),
                output.country(),
                output.zipcode(),
                LocalDate.parse(output.register()),
                UUID.fromString(output.ownerId())
        );
    }

    public static AddressInput toInput(AddressOutput output) {
        if (output == null) {
            throw new InvalidArgumentException(
                    "Could not convert address output model being null"
            );
        }

        return new AddressInput(
                UUID.fromString(output.id()),
                output.types().stream().map(AddressTypeOutput::toInput).collect(Collectors.toSet()),
                output.publicPlace(),
                output.number(),
                output.complement(),
                output.neighborhood(),
                output.city(),
                output.state(),
                output.country(),
                output.zipcode(),
                LocalDate.parse(output.register()),
                UUID.fromString(output.ownerId())
        );
    }

    public static AddressOutput from(Address model) {
        if (model == null) {
            throw new InvalidArgumentException(
                    "Could not convert address model being null"
            );
        }

        return new AddressOutput(
                model.id().toString(),
                model.types().stream().map(AddressTypeOutput::from).collect(Collectors.toSet()),
                model.publicPlace(),
                model.number(),
                model.complement(),
                model.neighborhood(),
                model.city(),
                model.state(),
                model.country(),
                model.zipcode(),
                model.register().toString(),
                model.ownerId().toString()
        );
    }
}
