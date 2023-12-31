package com.kingdom.manager.infrastructure.address.configs;

import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.infrastructure.address.persists.repositories.AddressGatewayImpl;
import com.kingdom.manager.infrastructure.address.persists.repositories.AddressTypeGatewayImpl;
import com.kingdom.manager.infrastructure.address.persists.repositories.JpaAddressRepository;
import com.kingdom.manager.infrastructure.address.persists.repositories.JpaAddressTypeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {

    @Bean public AddressTypeGateway typeGateway(JpaAddressTypeRepository repository) {
        return new AddressTypeGatewayImpl(repository);
    }

    @Bean public AddressGateway addressGateway(JpaAddressRepository repository) {
        return new AddressGatewayImpl(repository);
    }
}
