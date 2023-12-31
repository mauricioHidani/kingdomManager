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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeFindByTitleImplTest {

    private AddressTypeGateway gateway;
    private AddressTypeFindByTitleImpl useCase;

    private AddressType modelWithId;

    @BeforeEach void setUp() throws Exception {
        gateway = Mockito.mock(AddressTypeGateway.class);
        useCase = new AddressTypeFindByTitleImpl(gateway);

        modelWithId = AddressTypeFactory.newModel(1);
    }

    @DisplayName("Find By Title Should Return Found When Successful Find")
    @Test void execute_whenSuccessfulFind() {
        when(gateway.findByTitle("legal")).thenReturn(modelWithId);

        var result = useCase.execute("legal");

        verify(gateway, times(1)).findByTitle(any(String.class));

        assertNotNull(result);
        assertEquals(result.title(), modelWithId.title());
        assertEquals(result.description(), modelWithId.description());
    }

    @DisplayName("Find By Title Should Return Invalid Argument Exception When Title Is Blank")
    @Test void execute_whenTitleIsBlank() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(""));
    }

    @DisplayName("Find By Title Should Return Resource Not Found Exception When Does Not Found")
    @Test void execute_whenDoesNotFound() {
        when(gateway.findByTitle("legal")).thenReturn(null);
        assertThrows(ResourceNotFoundException.class, () -> useCase.execute("legal"));

        verify(gateway, times(1)).findByTitle(any(String.class));
    }

}