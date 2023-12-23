package com.kingdom.manager.application.address.usecases;

import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;

public interface AddressTypeCreate {
    AddressTypeOutput execute(AddressTypeInput input);
}
