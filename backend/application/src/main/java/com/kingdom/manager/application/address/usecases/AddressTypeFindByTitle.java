package com.kingdom.manager.application.address.usecases;

import com.kingdom.manager.application.address.out.AddressTypeOutput;

public interface AddressTypeFindByTitle {
    AddressTypeOutput execute(String title);
}
