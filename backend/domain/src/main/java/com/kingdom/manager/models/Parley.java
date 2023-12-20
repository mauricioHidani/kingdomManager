package com.kingdom.manager.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record Parley(
        UUID id,
        String title,
        String description,
        DestinyParley destiny,
        Set<Tag> tags,
        LocalDate register,
        BigDecimal amount,
        Person owner,
        Person addressee
) {
}
