package com.kingdom.manager.models;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record Address(
        UUID id,
        Set<AddressTypes> types,
        String publicPlace,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country,
        String zipcode,
        LocalDate register
) {
}
