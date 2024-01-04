package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.factories.AddressTypeFactory;
import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.application.address.usecases.AddressTypeUpdate;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeUpdateImplTest {

    private AddressTypeGateway gateway;
    private AddressTypeUpdateImpl useCase;

    private AddressType modelUpdate;
    private AddressType modelWithId;
    private AddressTypeInput input;
    private AddressTypeInput inputUpdate;

    @BeforeEach
    void setUp() throws Exception {
        gateway = Mockito.mock(AddressTypeGateway.class);
        useCase = new AddressTypeUpdateImpl(gateway);

        modelUpdate = new AddressType(1, "commercial", "description of commercial");
        modelWithId = AddressTypeFactory.newModel(1);
        input = AddressTypeFactory.newInput();
        inputUpdate = new AddressTypeInput("commercial", "description of commercial");
    }

    @Test
    @DisplayName("Update By Id Should Return Updated When Successful Update")
    void updateByIdShouldReturnUpdatedWhenSuccessfulUpdate() {
        when(gateway.getReferenceById(1)).thenReturn(modelWithId);
        when(gateway.save(modelUpdate)).thenReturn(modelUpdate);

        var result = useCase.execute(1, inputUpdate);

        verify(gateway, times(1)).getReferenceById(any(Integer.class));
        verify(gateway, times(1)).save(any(AddressType.class));

        assertNotNull(result);
        assertEquals(result.title(), modelUpdate.title());
        assertEquals(result.description(), modelUpdate.description());
        assertNotEquals(result.title(), modelWithId.title());
        assertNotEquals(result.description(), modelWithId.description());
    }

    @Test
    @DisplayName("Update By Id Should Throw Resource Not Found Exception When Does Not Found")
    void updateByIdShouldThrowResourceNotFoundExceptionWhenDoesNotFound() {
        when(gateway.getReferenceById(1000)).thenReturn(null);
        assertThrows(ResourceNotFoundException.class, () -> useCase.execute(1000, input));

        verify(gateway, times(1)).getReferenceById(any(Integer.class));
    }

    @Test
    @DisplayName("Update By Id Should Throw Invalid Argument Exception When Id Is Null")
    void updateByIdShouldThrowInvalidArgumentExceptionWhenIdIsNull() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(null, input));
    }

    @Test
    @DisplayName("Update By Id Should Throw Invalid Argument Exception When Id Less Then One")
    void updateByIdShouldThrowInvalidArgumentExceptionWhenIdLessThen() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(-1, input));
    }

    @Test
    @DisplayName("Update By Id Should Throw Invalid Argument Exception When Without Providing Information To Update")
    void updateByIdShouldThrowInvalidArgumentExceptionWhenWithoutProvidingInformationToUpdate() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(1, null));
    }

}