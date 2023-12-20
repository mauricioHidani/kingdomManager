package com.kingdom.manager.address;

import com.kingdom.manager.address.responses.AddressTypeResponse;

public interface AddressTypeFindById {
    AddressTypeResponse execute(Integer id);
}
