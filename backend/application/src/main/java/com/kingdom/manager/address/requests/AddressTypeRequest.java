package com.kingdom.manager.address.requests;

import com.kingdom.manager.models.AddressType;

public record AddressTypeRequest(
        String title,
        String description
) {
    public static AddressType to(AddressTypeRequest request) {
        return new AddressType(
                null,
                request.title(),
                request.description()
        );
    }
}
