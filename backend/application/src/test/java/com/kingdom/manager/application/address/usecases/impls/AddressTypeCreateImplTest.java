package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.factories.AddressTypeFactory;
import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.DatabaseException;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeCreateImplTest {

    private AddressTypeGateway gateway;
    private AddressTypeCreateImpl useCase;

    private AddressType newModel;
    private AddressType modelWithId;
    private AddressTypeOutput output;
    private AddressTypeInput input;

    @BeforeEach
    void setUp() throws Exception {
        gateway = Mockito.mock(AddressTypeGateway.class);
        useCase = new AddressTypeCreateImpl(gateway);

        newModel = AddressTypeFactory.newModel();
        modelWithId = AddressTypeFactory.newModel(1);
        input = AddressTypeFactory.newInput();
        output = AddressTypeFactory.newOutput();

        when(gateway.save(newModel)).thenReturn(modelWithId);
    }

    @Test
    @DisplayName("Create Should Return Output When Successful Create")
    void createShouldReturnOutputWhenSuccessfulCreate() {
        var result = useCase.execute(input);

        assertNotNull(result);
        assertEquals(result.title(), output.title());
        assertEquals(result.description(), output.description());
    }

    @Test
    @DisplayName("Create Should Throw Invalid Argument Exception When Input Is Null")
    void createShouldThrowInvalidArgumentExceptionWhenInputIsNull() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(null));
    }

    @Test
    @DisplayName("Create Should Throw Database Exception When Does Not Save")
    void createShouldThrowDatabaseExceptionWhenDoesNotSave() {
        when(gateway.save(newModel)).thenThrow(DatabaseException.class);
        assertThrows(DatabaseException.class, () -> useCase.execute(input));

        verify(gateway, times(1)).save(any(AddressType.class));
    }
}