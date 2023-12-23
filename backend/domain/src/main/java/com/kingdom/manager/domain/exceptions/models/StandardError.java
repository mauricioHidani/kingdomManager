package com.kingdom.manager.domain.exceptions.models;

import java.time.Instant;

public record StandardError(
        Instant timestamp,
        Integer status,
        String error,
        String path
) {
}
