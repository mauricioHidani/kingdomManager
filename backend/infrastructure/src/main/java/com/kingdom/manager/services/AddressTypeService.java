package com.kingdom.manager.services;

import com.kingdom.manager.address.AddressTypeCreate;
import com.kingdom.manager.address.AddressTypeFindById;
import com.kingdom.manager.address.requests.AddressTypeRequest;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressTypeService {

    private final AddressTypeCreate create;
    private final AddressTypeFindById findById;

    public AddressTypeService(
            AddressTypeCreate create,
            AddressTypeFindById findById
    ) {
        this.create = create;
        this.findById = findById;
    }

    @Transactional
    public AddressTypeResponse create(AddressTypeRequest request) {
        return create.execute(request);
    }

    @Transactional(readOnly = true)
    public AddressTypeResponse findById(Integer id) {
        return findById.execute(id);
    }

}
