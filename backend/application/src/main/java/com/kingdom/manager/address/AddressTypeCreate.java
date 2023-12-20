package com.kingdom.manager.address;

import com.kingdom.manager.address.requests.AddressTypeRequest;
import com.kingdom.manager.address.responses.AddressTypeResponse;

public interface AddressTypeCreate {
    AddressTypeResponse execute(AddressTypeRequest request);
}
