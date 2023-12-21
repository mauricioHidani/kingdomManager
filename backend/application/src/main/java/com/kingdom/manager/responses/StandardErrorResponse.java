package com.kingdom.manager.responses;

import java.time.Instant;

public record StandardErrorResponse(
        Instant timestamp,
        Integer status,
        String error,
        String path
) {
}
