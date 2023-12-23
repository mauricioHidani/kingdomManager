package com.kingdom.manager.application.address.factories;

import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.domain.address.models.AddressType;

public class AddressTypeFactory {
    public static AddressType newModel() {
        return new AddressType(
                null,
                "legal",
                "this is a description of a address type legal"
        );
    }

    public static AddressType newModel(Integer id) {
        return new AddressType(
                id,
                "legal",
                "this is a description of a address type legal"
        );
    }

    public static AddressTypeInput newInput() {
        return new AddressTypeInput(
                "legal",
                "this is a description of a address type legal"
        );
    }

    public static AddressTypeOutput newOutput() {
        return new AddressTypeOutput(
                "legal",
                "this is a description of a address type legal"
        );
    }
}
