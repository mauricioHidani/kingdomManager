package com.kingdom.manager.infrastructure.address.services;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.application.address.usecases.*;
import com.kingdom.manager.application.address.usecases.impls.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressTypeService {

    private final AddressTypeCreate create;
    private final AddressTypeFindById findById;
    private final AddressTypeFindAll findAll;
    private final AddressTypeFindByTitle findByTitle;
    private final AddressTypeDelete delete;
    private final AddressTypeUpdate update;

    public AddressTypeService(AddressTypeGateway gateway) {
        this.create = new AddressTypeCreateImpl(gateway);
        this.findById = new AddressTypeFindByIdImpl(gateway);
        this.findAll = new AddressTypeFindAllImpl(gateway);
        this.findByTitle = new AddressTypeFindByTitleImpl(gateway);
        this.delete = new AddressTypeDeleteImpl(gateway);
        this.update = new AddressTypeUpdateImpl(gateway);
    }

    @Transactional(readOnly = true)
    public AddressTypeOutput findByTitle(String title) {
        return findByTitle.execute(title);
    }

    @Transactional(readOnly = true)
    public AddressTypeOutput findById(Integer id) {
        return findById.execute(id);
    }

    @Transactional(readOnly = true)
    public List<AddressTypeOutput> findAll() {
        return findAll.execute();
    }

    @Transactional
    public AddressTypeOutput create(AddressTypeInput input) {
        return create.execute(input);
    }

    @Transactional
    public void delete(Integer id) {
        delete.execute(id);
    }

    @Transactional
    public AddressTypeOutput update(Integer id, AddressTypeInput input) {
        return update.execute(id, input);
    }

}
