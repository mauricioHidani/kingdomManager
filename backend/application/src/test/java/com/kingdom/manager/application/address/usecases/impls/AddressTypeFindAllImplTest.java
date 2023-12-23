package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.factories.AddressTypeFactory;
import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeFindAllImplTest {

    private AddressTypeGateway gateway;
    private AddressTypeFindAllImpl useCase;

    private AddressType modelWithId;

    @BeforeEach void setUp() {
        gateway = Mockito.mock(AddressTypeGateway.class);
        useCase = new AddressTypeFindAllImpl(gateway);

        modelWithId = AddressTypeFactory.newModel(1);
    }

    @DisplayName("Find All Should Return All Found When Successful Find")
    @Test void execute_whenSuccessfulFind() {
        when(gateway.findAll()).thenReturn(List.of(modelWithId));

        var result = useCase.execute();

        verify(gateway, times(1)).findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(result.getFirst().title(), modelWithId.title());
        assertEquals(result.getFirst().description(), modelWithId.description());
    }

    @DisplayName("Find All Should Return Resource Not Found Exception When Not Found")
    @Test void execute_whenNotFound() {
        when(gateway.findAll()).thenReturn(List.of());

        assertThrows(ResourceNotFoundException.class, () -> useCase.execute());

        verify(gateway, times(1)).findAll();
    }

}