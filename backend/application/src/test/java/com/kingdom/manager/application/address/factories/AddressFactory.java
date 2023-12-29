package com.kingdom.manager.application.address.factories;

import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.domain.address.models.Address;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

public class AddressFactory {
    public static Address newModel() {
        return new Address(
                null,
                new HashSet<>(),
                "Avenida João Erbolato",
                "1231",
                null,
                "Vila Cambucci",
                "Campinas",
                "SP",
                "BR",
                "13070-071",
                LocalDate.of(2023, 11, 25),
                UUID.fromString("a4a78c78-0391-4802-9777-083f271536d1")
        );
    }

    public static Address newModel(UUID id) {
        return new Address(
                id,
                new HashSet<>(),
                "Avenida João Erbolato",
                "1231",
                null,
                "Vila Cambucci",
                "Campinas",
                "SP",
                "BR",
                "13070-071",
                LocalDate.of(2023, 11, 25),
                UUID.fromString("a4a78c78-0391-4802-9777-083f271536d1")
        );
    }

    public static AddressInput newInput() {
        return new AddressInput(
                null,
                new HashSet<>(),
                "Avenida João Erbolato",
                "1231",
                null,
                "Vila Cambucci",
                "Campinas",
                "SP",
                "BR",
                "13070-071",
                LocalDate.of(2023, 11, 25),
                UUID.fromString("a4a78c78-0391-4802-9777-083f271536d1")
        );
    }

    public static AddressInput newInput(UUID id) {
        return new AddressInput(
                id,
                new HashSet<>(),
                "Avenida João Erbolato",
                "1231",
                null,
                "Vila Cambucci",
                "Campinas",
                "SP",
                "BR",
                "13070-071",
                LocalDate.of(2023, 11, 25),
                UUID.fromString("a4a78c78-0391-4802-9777-083f271536d1")
        );
    }

    public static AddressOutput newOutput(UUID id) {
        return new AddressOutput(
                id.toString(),
                new HashSet<>(),
                "Avenida João Erbolato",
                "1231",
                null,
                "Vila Cambucci",
                "Campinas",
                "SP",
                "BR",
                "13070-071",
                "2023-11-25",
                "a4a78c78-0391-4802-9777-083f271536d1"
        );
    }
}
