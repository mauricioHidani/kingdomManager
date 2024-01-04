package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeDeleteImplTest {

    private AddressTypeGateway gateway;
    private AddressTypeDeleteImpl useCase;

    @BeforeEach
    void setUp() throws Exception {
        gateway = Mockito.mock(AddressTypeGateway.class);
        useCase = new AddressTypeDeleteImpl(gateway);
    }

    @Test
    @DisplayName("Delete By Id Should Return Nothing When Successful Delete")
    void deleteByIdShouldReturnNothingWhenSuccessfulDelete() {
        doNothing().when(gateway).delete(1);
        when(gateway.existingById(1)).thenReturn(true);

        useCase.execute(1);

        verify(gateway, times(1)).existingById(any(Integer.class));
        verify(gateway, times(1)).delete(any(Integer.class));
    }

    @Test
    @DisplayName("Delete By Id Should Throw Invalid Argument Exception When Id Is Null")
    void deleteByIdShouldThrowInvalidArgumentExceptionWhenIdIsNull() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(null));
    }

    @Test
    @DisplayName("Delete By Id Should Throw Invalid Argument Exception When Id Less Then One")
    void deleteByIdShouldThrowInvalidArgumentExceptionWhenIdLessThenOne() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(-1));
    }

    @Test
    @DisplayName("Delete By Id Should Throw Resource Not Found Exception When Does Not Found")
    void deleteByIdShouldThrowResourceNotFoundExceptionWhenDoesNotFound() {
        when(gateway.existingById(1000)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> useCase.execute(1000));

        verify(gateway, times(1)).existingById(any(Integer.class));
    }

}