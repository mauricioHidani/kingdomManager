package com.kingdom.manager.address.fatories;

import com.kingdom.manager.address.requests.AddressTypeRequest;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import com.kingdom.manager.models.AddressType;

public class AddressTypeFactory {

    public static AddressType newModel() {
        return new AddressType(
                null,
                "commercial",
                "this is a description of commercial"
        );
    }

    public static AddressType newModel(Integer id) {
        return new AddressType(
                id,
                "commercial",
                "this is a description of commercial"
        );
    }

    public static AddressTypeRequest newRequest() {
        return new AddressTypeRequest(
                "commercial",
                "this is a description of commercial"
        );
    }

    public static AddressTypeResponse newResponse() {
        return new AddressTypeResponse(
                "commercial",
                "this is a description of commercial"
        );
    }

    public static String title() {
        return "commercial";
    }

    public static String description() {
        return "this is a description of commercial";
    }
}
