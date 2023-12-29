package com.kingdom.manager.application.address.usecases;

import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;

public interface AddressCreate {
    AddressOutput execute(AddressInput input);
}
