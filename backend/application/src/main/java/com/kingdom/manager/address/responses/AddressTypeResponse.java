package com.kingdom.manager.address.responses;

import com.kingdom.manager.models.AddressType;

public record AddressTypeResponse(
        String title,
        String description
) {
    public static AddressTypeResponse from(AddressType model) {
        return new AddressTypeResponse(
                model.title(),
                model.description()
        );
    }
}
