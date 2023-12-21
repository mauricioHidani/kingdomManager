package com.kingdom.manager.services;

import com.kingdom.manager.address.AddressTypeCreate;
import com.kingdom.manager.address.requests.AddressTypeRequest;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressTypeService {

    private final AddressTypeCreate create;

    public AddressTypeService(AddressTypeCreate create) {
        this.create = create;
    }

    @Transactional
    public AddressTypeResponse create(AddressTypeRequest request) {
        return create.execute(request);
    }
}
