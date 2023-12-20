package com.kingdom.manager.address.impls;

import com.kingdom.manager.address.AddressTypeCreate;
import com.kingdom.manager.address.requests.AddressTypeRequest;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import com.kingdom.manager.exceptions.DatabaseException;
import com.kingdom.manager.exceptions.DatabaseIntegrityException;
import com.kingdom.manager.models.AddressType;
import com.kingdom.manager.persists.AddressTypeRepository;

public class AddressTypeCreateImpl implements AddressTypeCreate {

    private final AddressTypeRepository repository;

    public AddressTypeCreateImpl(AddressTypeRepository repository) {
        this.repository = repository;
    }

    @Override public AddressTypeResponse execute(AddressTypeRequest request) {
        if (repository.existingByTitle(request.title())) {
            throw new DatabaseIntegrityException("It is not possible to save the same existing address type");
        }

        AddressType parsed = AddressTypeRequest.to(request);
        AddressType saved = repository.save(parsed);

        if (saved == null) {
            throw new DatabaseException("There was not possible to save address type");
        }

        return AddressTypeResponse.from(saved);
    }
}
