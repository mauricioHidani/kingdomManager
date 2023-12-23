package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.factories.AddressTypeFactory;
import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class AddressTypeFindByIdImplTest {

    private AddressTypeGateway gateway;
    private AddressTypeFindByIdImpl useCase;

    private AddressType modelWithId;

    @BeforeEach void setUp() throws Exception {
        gateway = Mockito.mock(AddressTypeGateway.class);
        useCase = new AddressTypeFindByIdImpl(gateway);

        modelWithId = AddressTypeFactory.newModel(1);
    }

    @DisplayName("Find By Id Should Return Found When Successful Find")
    @Test void execute_whenSuccessfulFind() {
        when(gateway.findById(1)).thenReturn(Optional.of(modelWithId));

        var result = useCase.execute(1);

        verify(gateway, times(1)).findById(any(Integer.class));

        assertNotNull(result);
        assertEquals(result.title(), modelWithId.title());
        assertEquals(result.description(), modelWithId.description());
    }

    @DisplayName("Find By Id Should Return Invalid Argument Exception When Id Is Null")
    @Test void execute_whenIdIsNull() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(null));
    }

    @DisplayName("Find By Id Should Return Invalid Argument Exception When Id Less Then One")
    @Test void execute_whenIdLessThenOne() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(-1));
    }

    @DisplayName("Find By Id Should Return Resource Not Found Exception When Does Not Found")
    @Test void execute_whenDoesNotFound() {
        when(gateway.findById(1000)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> useCase.execute(1000));

        verify(gateway, times(1)).findById(any(Integer.class));
    }
}