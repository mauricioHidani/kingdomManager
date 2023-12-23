package com.kingdom.manager.domain.address.models;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record Address(
        UUID id,
        Set<AddressType> types,
        String publicPlace,
        String number,
        String complement,
        String city,
        String state,
        String country,
        String zipcode,
        LocalDate register,
        UUID ownerId
) {
}
