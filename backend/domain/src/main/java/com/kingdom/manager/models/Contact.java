package com.kingdom.manager.models;

import java.time.LocalDate;
import java.util.UUID;

public record Contact(
        UUID id,
        String contact,
        ContactType types,
        LocalDate register,
        Boolean active
) {
}
