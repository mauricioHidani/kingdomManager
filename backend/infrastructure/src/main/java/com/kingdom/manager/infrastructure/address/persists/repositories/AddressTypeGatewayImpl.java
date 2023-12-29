package com.kingdom.manager.infrastructure.address.persists.repositories;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.infrastructure.address.mappers.AddressTypeMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public class AddressTypeGatewayImpl implements AddressTypeGateway {

    private final JpaAddressTypeRepository repository;

    public AddressTypeGatewayImpl(JpaAddressTypeRepository repository) {
        this.repository = repository;
    }

    @Override public AddressType findByTitle(String title) {
        var result = repository.findByTitle(title);
        return AddressTypeMapper.toModel(result);
    }

    @Override public Boolean existingById(Integer id) {
        return repository.existsById(id);
    }

    @Override public AddressType getReferenceById(Integer id) {
        var result = repository.getReferenceById(id);
        return AddressTypeMapper.toModel(result);
    }

    @Override public Optional<AddressType> findById(Integer id) {
        var result = repository.findById(id);
        return AddressTypeMapper.toModel(result);
    }

    @Override public List<AddressType> findAll() {
        var result = repository.findAll();
        return result.stream()
                .map(AddressTypeMapper::toModel)
                .toList();
    }

    @Override public AddressType save(AddressType addressType) {
        var result = repository.save(
                AddressTypeMapper.toEntity(addressType)
        );
        return AddressTypeMapper.toModel(result);
    }

    @Override public void delete(Integer id) {
        repository.deleteById(id);
    }

}
