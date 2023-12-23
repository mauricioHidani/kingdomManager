package com.kingdom.manager.infrastructure.address.mappers;

import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.infrastructure.address.factories.AddressTypeFactory;
import com.kingdom.manager.infrastructure.address.persists.entities.AddressTypeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

class AddressTypeMapperTest {

    private AddressTypeEntity newEntity;
    private AddressTypeInput input;

    @BeforeEach void setUp() throws Exception {
        newEntity = AddressTypeFactory.newEntity();
        input = AddressTypeFactory.newInput();
    }

    // TODO : create tests
}