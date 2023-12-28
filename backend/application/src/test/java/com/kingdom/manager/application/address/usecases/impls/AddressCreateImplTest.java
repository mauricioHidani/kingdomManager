package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.factories.AddressFactory;
import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.domain.exceptions.DatabaseException;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressCreateImplTest {

    private AddressGateway gateway;
    private AddressCreateImpl useCase;

    private UUID id;
    private Address newModel;
    private Address modelWithId;
    private AddressInput input;
    private AddressOutput output;

    @BeforeEach void setUp() throws Exception {
        gateway = Mockito.mock(AddressGateway.class);
        useCase = new AddressCreateImpl(gateway);

        id = UUID.randomUUID();
        newModel = AddressFactory.newModel();
        modelWithId = AddressFactory.newModel(id);
        input = AddressFactory.newInput();
        output = AddressFactory.newOutput(id);
    }

    @DisplayName("Create Address Should Return Output When Successful Create")
    @Test void execute_whenSuccessfulCreate() {
        when(gateway.save(newModel)).thenReturn(modelWithId);

        var result = useCase.execute(input);

        verify(gateway, times(1)).save(any(Address.class));

        assertNotNull(result);
        assertEquals(result.id(), output.id());
        assertTrue(result.types().containsAll(output.types()));
        assertEquals(result.publicPlace(), output.publicPlace());
        assertEquals(result.number(), output.number());
        assertEquals(result.complement(), output.complement());
        assertEquals(result.city(), output.city());
        assertEquals(result.state(), output.state());
        assertEquals(result.country(), output.country());
        assertEquals(result.zipcode(), output.zipcode());
        assertEquals(result.register(), output.register());
        assertEquals(result.ownerId(), output.ownerId());
    }

    @DisplayName("Create Address Should Return Invalid Argument Exception When Input Is Null")
    @Test void execute_whenInputIsNull() {
        assertThrows(InvalidArgumentException.class, () -> useCase.execute(null));
    }

    @DisplayName("Create Address Should Return Database Exception When Does Not Create")
    @Test void execute_whenDoesNotCreate() {
        when(gateway.save(newModel)).thenReturn(null);

        assertThrows(DatabaseException.class, () -> useCase.execute(input));

        verify(gateway, times(1)).save(newModel);
    }

}