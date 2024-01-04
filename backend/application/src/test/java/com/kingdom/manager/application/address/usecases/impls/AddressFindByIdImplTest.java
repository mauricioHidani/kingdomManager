package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.factories.AddressFactory;
import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AddressFindByIdImplTest {

    private AddressGateway gateway;
    private AddressFindByIdImpl useCase;

    private UUID existingId;
    private UUID noExistingId;
    private Address addressModel;

    @BeforeEach
    void setUp() throws Exception {
        gateway = Mockito.mock(AddressGateway.class);
        useCase = new AddressFindByIdImpl(gateway);

        existingId = UUID.randomUUID();
        noExistingId = UUID.randomUUID();
        addressModel = AddressFactory.newModel(existingId);

        when(gateway.findById(existingId)).thenReturn(Optional.of(addressModel));
    }

    @Test
    @DisplayName("Find By Id Should Return Found When Successful Find")
    void findByIdShouldReturnFoundWhenSuccessfulFind() {
        var result = useCase.execute(existingId);

        verify(gateway).findById(any());

        assertNotNull(result);
        assertEquals(result.id(), addressModel.id().toString());
        assertEquals(result.publicPlace(), addressModel.publicPlace());
        assertEquals(result.number(), addressModel.number());
        assertEquals(result.complement(), addressModel.complement());
        assertEquals(result.city(), addressModel.city());
        assertEquals(result.state(), addressModel.state());
        assertEquals(result.country(), addressModel.country());
        assertEquals(result.zipcode(), addressModel.zipcode());
        assertEquals(result.register(), addressModel.register().toString());
    }

    @Test
    @DisplayName("Find By Id Should Throw Invalid Argument Exception When Id Is Null")
    void findByIdShouldThrowInvalidArgumentExceptionWhenIdIsBlank() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(null));
    }

    @Test
    @DisplayName("Find By Id Should Throw Resource Not Found Exception When Does Not Found")
    void findByIdShouldThrowResourceNotFoundExceptionWhenDoesNotFound() {
        when(gateway.findById(noExistingId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> useCase.execute(noExistingId));

        verify(gateway).findById(any());
    }

}