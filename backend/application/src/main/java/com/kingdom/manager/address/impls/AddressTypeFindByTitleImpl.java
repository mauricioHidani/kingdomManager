package com.kingdom.manager.address.impls;

import com.kingdom.manager.address.AddressTypeFindByTitle;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import com.kingdom.manager.exceptions.InvalidRequestException;
import com.kingdom.manager.exceptions.ResourceNotFoundException;
import com.kingdom.manager.models.AddressType;
import com.kingdom.manager.persists.AddressTypeRepository;

public class AddressTypeFindByTitleImpl implements AddressTypeFindByTitle {

    private final AddressTypeRepository repository;

    public AddressTypeFindByTitleImpl(AddressTypeRepository repository) {
        this.repository = repository;
    }

    @Override public AddressTypeResponse execute(String title) {
        if (title.isBlank()) {
            throw new InvalidRequestException("The information of the request is not valid");
        }

        AddressType found = repository.findByTitle(title);
        if (found == null) {
            throw new ResourceNotFoundException("Address type does not found by title");
        }
        return AddressTypeResponse.from(found);
    }
}
