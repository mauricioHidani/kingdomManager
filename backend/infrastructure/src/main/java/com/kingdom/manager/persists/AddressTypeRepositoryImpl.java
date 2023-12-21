package com.kingdom.manager.persists;

import com.kingdom.manager.entities.AddressTypeEntity;
import com.kingdom.manager.models.AddressType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressTypeRepositoryImpl implements AddressTypeRepository {

    private final JpaAddressTypeRepository repository;

    public AddressTypeRepositoryImpl(JpaAddressTypeRepository repository) {
        this.repository = repository;
    }

    @Override public AddressType save(AddressType addressType) {
        var result = repository.save(
                new AddressTypeEntity(
                        addressType.title(),
                        addressType.description()
                )
        );
        return new AddressType(
                result.getId(),
                result.getTitle(),
                result.getDescription()
        );
    }

    @Override
    public Optional<AddressType> findById(Integer id) {
        return Optional.empty();
    }

    @Override public Boolean existingByTitle(String title) {
        return repository.findByTitle(title) != null;
    }

    @Override
    public AddressType findByTitle(String title) {
        var result = repository.findByTitle(title);
        return new AddressType(
                result.getId(),
                result.getTitle(),
                result.getDescription()
        );
    }

    @Override
    public List<AddressType> findByTitles(List<String> titles) {
        return null;
    }
}
