package com.kingdom.manager.infrastructure.address.mappers;

import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.infrastructure.address.factories.AddressTypeFactory;
import com.kingdom.manager.infrastructure.address.persists.entities.AddressTypeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class AddressTypeMapperTest {

    private Integer id;
    private AddressType modelWithId;
    private AddressTypeEntity entity;

    @BeforeEach void setUp() throws Exception {
        id = 1;
        modelWithId = AddressTypeFactory.newModel(id);
        entity = AddressTypeFactory.newEntity(id);
    }

    @DisplayName("Convert Model To Entity Should Return Entity When Successful Convert")
    @Test void toEntity_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeMapper> utilities = mockStatic(AddressTypeMapper.class)) {
            utilities.when(() -> AddressTypeMapper.toEntity(modelWithId)).thenReturn(entity);

            var result = AddressTypeMapper.toEntity(modelWithId);

            assertNotNull(result);
            assertEquals(result.getId(), entity.getId());
            assertEquals(result.getTitle(), entity.getTitle());
            assertEquals(result.getDescription(), entity.getDescription());
        }
    }

    @DisplayName("Convert Model To Entity Should Return Invalid Argument Exception When Model Is Null")
    @Test void toEntity_whenModelIsNull() {
        try (MockedStatic<AddressTypeMapper> utilities = mockStatic(AddressTypeMapper.class)) {
            utilities.when(() -> AddressTypeMapper.toEntity(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeMapper.toEntity(null));
        }
    }

    @DisplayName("Convert Entity To Model Should Return Model When Successful Convert")
    @Test void toModel_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeMapper> utilities = mockStatic(AddressTypeMapper.class)) {
            utilities.when(() -> AddressTypeMapper.toModel(entity)).thenReturn(modelWithId);

            var result = AddressTypeMapper.toModel(entity);

            assertNotNull(result);
            assertEquals(result.id(), modelWithId.id());
            assertEquals(result.title(), modelWithId.title());
            assertEquals(result.description(), modelWithId.description());
        }
    }

    @DisplayName("Convert Entity To Model Should Return Invalid Argument Exception When Entity is Null")
    @Test void toModel_whenEntityIsNull() {
        try (MockedStatic<AddressTypeMapper> utilities = mockStatic(AddressTypeMapper.class)) {
            utilities.when(() -> AddressTypeMapper.toModel((AddressTypeEntity) null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeMapper.toModel((AddressTypeEntity) null));
        }
    }

    @DisplayName("Convert Optional Entity To Optional Model Should Return Optional Model When Successful Convert")
    @Test void toOptionalModel_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeMapper> utilities = mockStatic(AddressTypeMapper.class)) {
            utilities.when(() -> AddressTypeMapper.toModel(Optional.of(entity))).thenReturn(Optional.of(modelWithId));

            var result = AddressTypeMapper.toModel(Optional.of(entity));

            assertTrue(result instanceof Optional);
            assertEquals(result.get().id(), entity.getId());
            assertEquals(result.get().title(), entity.getTitle());
            assertEquals(result.get().description(), entity.getDescription());
        }
    }

    @DisplayName("Convert Optional Entity To Optional Model Should Return Invalid Argument Exception When Optional Entity Id Empty")
    @Test void toOptionalModel_whenOptionalEntityIsEmpty() {
        try (MockedStatic<AddressTypeMapper> utilities = mockStatic(AddressTypeMapper.class)) {
            utilities.when(() -> AddressTypeMapper.toModel(Optional.empty())).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeMapper.toModel(Optional.empty()));
        }
    }

}