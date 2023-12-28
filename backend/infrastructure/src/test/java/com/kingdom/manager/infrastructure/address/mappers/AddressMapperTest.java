package com.kingdom.manager.infrastructure.address.mappers;

import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.infrastructure.address.factories.AddressFactory;
import com.kingdom.manager.infrastructure.address.persists.entities.AddressEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class AddressMapperTest {

    private UUID id;
    private Address modelWithId;
    private AddressEntity entity;

    @BeforeEach void setUp() throws Exception {
        id = UUID.randomUUID();
        modelWithId = AddressFactory.newModel(id);
        entity = AddressFactory.newEntity(id);
    }

    @DisplayName("Convert Model To Entity Should Return Entity When ")
    @Test void toEntity_whenSuccessfulConvert() {
        try (MockedStatic<AddressMapper> utilities = mockStatic(AddressMapper.class)) {
            utilities.when(() -> AddressMapper.toEntity(modelWithId)).thenReturn(entity);

            var result = AddressMapper.toEntity(modelWithId);

            assertNotNull(result);
            assertEquals(result.getId(), modelWithId.id());
            assertEquals(result.getPublicPlace(), modelWithId.publicPlace());
            assertEquals(result.getNumber(), modelWithId.number());
            assertEquals(result.getComplement(), modelWithId.complement());
            assertEquals(result.getNeighborhood(), modelWithId.neighborhood());
            assertEquals(result.getCity(), modelWithId.city());
            assertEquals(result.getState(), modelWithId.state());
            assertEquals(result.getCountry(), modelWithId.country());
            assertEquals(result.getZipcode(), modelWithId.zipcode());
            assertEquals(result.getRegister(), modelWithId.register());
            assertEquals(result.getOwner().getId(), modelWithId.ownerId());
        }

        var result = AddressMapper.toEntity(modelWithId);

        assertNotNull(result);
        assertEquals(result.getId(), modelWithId.id());
        assertEquals(result.getPublicPlace(), modelWithId.publicPlace());
        assertEquals(result.getNumber(), modelWithId.number());
        assertEquals(result.getComplement(), modelWithId.complement());
        assertEquals(result.getNeighborhood(), modelWithId.neighborhood());
        assertEquals(result.getCity(), modelWithId.city());
        assertEquals(result.getState(), modelWithId.state());
        assertEquals(result.getCountry(), modelWithId.country());
        assertEquals(result.getZipcode(), modelWithId.zipcode());
        assertEquals(result.getRegister(), modelWithId.register());
        assertEquals(result.getOwner().getId(), modelWithId.ownerId());
    }
    
    @DisplayName("Convert Model To Entity Should Return Invalid Argument Exception When Model Is Null")
    @Test void toEntity_whenModelIsNull() {
        try (MockedStatic<AddressMapper> utilities = mockStatic(AddressMapper.class)) {
            utilities.when(() -> AddressMapper.toEntity(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressMapper.toEntity(null));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressMapper.toEntity(null));
    }

    @DisplayName("Convert Entity To Model Should Return Model When Successful Convert")
    @Test void toModel_whenSuccessfulConvert() {
        try (MockedStatic<AddressMapper> utilities = mockStatic(AddressMapper.class)) {
            utilities.when(() -> AddressMapper.toModel(entity)).thenReturn(modelWithId);

            var result = AddressMapper.toModel(entity);

            assertNotNull(result);
            assertEquals(result.id(), entity.getId());
            assertEquals(result.publicPlace(), entity.getPublicPlace());
            assertEquals(result.number(), entity.getNumber());
            assertEquals(result.complement(), entity.getComplement());
            assertEquals(result.neighborhood(), entity.getNeighborhood());
            assertEquals(result.city(), entity.getCity());
            assertEquals(result.state(), entity.getState());
            assertEquals(result.country(), entity.getCountry());
            assertEquals(result.zipcode(), entity.getZipcode());
            assertEquals(result.register(), entity.getRegister());
            assertEquals(result.ownerId(), entity.getOwner().getId());
        }
    }

    @DisplayName("Convert Entity To Model Should Return Invalid Argument Exception When Entity is Null")
    @Test void toModel_whenEntityIsNull() {
        try (MockedStatic<AddressMapper> utilities = mockStatic(AddressMapper.class)) {
            utilities.when(() -> AddressMapper.toModel((AddressEntity) null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressMapper.toModel((AddressEntity) null));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressMapper.toModel((AddressEntity) null));
    }

    @DisplayName("Convert Optional Entity To Optional Model Should Return Optional Model When Successful Convert")
    @Test void toOptionalModel_whenSuccessfulConvert() {
        try (MockedStatic<AddressMapper> utilities = mockStatic(AddressMapper.class)) {
            utilities.when(() -> AddressMapper.toModel(Optional.of(entity))).thenReturn(Optional.of(modelWithId));

            var result = AddressMapper.toModel(Optional.of(entity));

            assertTrue(result instanceof Optional);
            assertEquals(result.get().id(), entity.getId());
            assertEquals(result.get().publicPlace(), entity.getPublicPlace());
            assertEquals(result.get().number(), entity.getNumber());
            assertEquals(result.get().complement(), entity.getComplement());
            assertEquals(result.get().neighborhood(), entity.getNeighborhood());
            assertEquals(result.get().city(), entity.getCity());
            assertEquals(result.get().state(), entity.getState());
            assertEquals(result.get().country(), entity.getCountry());
            assertEquals(result.get().zipcode(), entity.getZipcode());
            assertEquals(result.get().register(), entity.getRegister());
            assertEquals(result.get().ownerId(), entity.getOwner().getId());
        }
    }

    @DisplayName("Convert Optional Entity To Optional Model Should Return Invalid Argument Exception When Optional Entity Id Empty")
    @Test void toOptionalModel_whenOptionalEntityIsEmpty() {
        try (MockedStatic<AddressMapper> utilities = mockStatic(AddressMapper.class)) {
            utilities.when(() -> AddressMapper.toModel(Optional.empty())).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressMapper.toModel(Optional.empty()));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressMapper.toModel(Optional.empty()));
    }

}