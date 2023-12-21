package com.kingdom.manager.configurations;

import com.kingdom.manager.address.AddressTypeCreate;
import com.kingdom.manager.address.AddressTypeFindById;
import com.kingdom.manager.address.AddressTypeFindByTitle;
import com.kingdom.manager.address.impls.AddressTypeCreateImpl;
import com.kingdom.manager.address.impls.AddressTypeFindByIdImpl;
import com.kingdom.manager.address.impls.AddressTypeFindByTitleImpl;
import com.kingdom.manager.persists.AddressTypeRepositoryImpl;
import com.kingdom.manager.persists.JpaAddressTypeRepository;
import com.kingdom.manager.services.AddressTypeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressTypeConfig {

    @Bean public AddressTypeCreate create(JpaAddressTypeRepository repository) {
        return new AddressTypeCreateImpl(
                repository(repository)
        );
    }

    @Bean public AddressTypeFindById findById(JpaAddressTypeRepository repository) {
        return new AddressTypeFindByIdImpl(
                repository(repository)
        );
    }

    @Bean public AddressTypeFindByTitle findByTitle(JpaAddressTypeRepository repository) {
        return new AddressTypeFindByTitleImpl(
                repository(repository)
        );
    }

    @Bean public AddressTypeRepositoryImpl repository(JpaAddressTypeRepository repository) {
        return new AddressTypeRepositoryImpl(repository);
    }

    @Bean public AddressTypeService service(JpaAddressTypeRepository repository) {
        return new AddressTypeService(
                create(repository),
                findById(repository),
                findByTitle(repository)
        );
    }

 }
