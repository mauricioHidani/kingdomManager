package com.kingdom.manager.address;

import com.kingdom.manager.address.responses.AddressTypeResponse;

public interface AddressTypeFindByTitle {
    AddressTypeResponse execute(String title);
}
