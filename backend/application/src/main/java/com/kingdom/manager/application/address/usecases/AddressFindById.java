package com.kingdom.manager.application.address.usecases;

import com.kingdom.manager.application.address.out.AddressOutput;

import java.util.UUID;

public interface AddressFindById {
    AddressOutput execute(UUID input);
}
