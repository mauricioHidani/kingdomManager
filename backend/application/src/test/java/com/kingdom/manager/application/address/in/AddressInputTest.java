package com.kingdom.manager.application.address.in;

import com.kingdom.manager.application.address.factories.AddressFactory;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

class AddressInputTest {

    private UUID id;
    private Address newModel;
    private Address modelWithId;
    private AddressInput input;
    private AddressInput inputWithId;
    private AddressOutput output;

    @BeforeEach void setUp() throws Exception {
        id = UUID.randomUUID();
        newModel = AddressFactory.newModel();
        modelWithId = AddressFactory.newModel(id);
        input = AddressFactory.newInput();
        inputWithId = AddressFactory.newInput(id);
        output = AddressFactory.newOutput(id);
    }

    @DisplayName("Convert Address Input Model By Model Should Return Model When Successful Convert")
    @Test void toModel_whenSuccessfulConvert() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.toModel(input)).thenReturn(newModel);
            assertEquals(AddressInput.toModel(input), newModel);
        }

        assertEquals(AddressInput.toModel(input), newModel);
    }

    @DisplayName("Convert Address Input Model By Model Should Return Invalid Argument Exception When Input Is Null")
    @Test void toModel_whenInputIsNull() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.toModel(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressInput.toModel(null));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressInput.toModel(null));
    }

    @DisplayName("Convert Address Input With Id By Model Should Return Model When Successful Convert")
    @Test void toModelWithId_whenSuccessfulConvert() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.toModel(id, input)).thenReturn(modelWithId);
            assertEquals(AddressInput.toModel(id, input), modelWithId);
        }
        assertEquals(AddressInput.toModel(id, input), modelWithId);
    }

    @DisplayName("Convert Address Input With Id By Model Should Return Invalid Argument Exception When Id Is Null")
    @Test void toModelWithId_whenIdIsNull() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.toModel(null, input)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressInput.toModel(null, input));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressInput.toModel(null, input));
    }

    @DisplayName("Convert Address Input With Id By Model Should Return Invalid Argument Exception When Input Is Null")
    @Test void toModelWithId_whenInputIsNull() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.toModel(id, null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressInput.toModel(id, null));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressInput.toModel(id, null));
    }

    @DisplayName("Convert Address Input By Output Should Return Output When Successful Convert")
    @Test void toOutput_whenSuccessfulConvert() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.toOutput(inputWithId)).thenReturn(output);
            assertEquals(AddressInput.toOutput(inputWithId), output);
        }
        assertEquals(AddressInput.toOutput(inputWithId), output);
    }

    @DisplayName("Convert Address Input By Output Should Return Invalid Argument Exception When Input Is Null")
    @Test void toOutput_whenInputIsNull() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.toOutput(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressInput.toOutput(null));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressInput.toOutput(null));
    }

    @DisplayName("Convert Address Model By Input Should Return Input When Successful Convert")
    @Test void from_whenSuccessfulConvert() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.from(modelWithId)).thenReturn(inputWithId);
            assertEquals(AddressInput.from(modelWithId), inputWithId);
        }
        assertEquals(AddressInput.from(modelWithId), inputWithId);
    }

    @DisplayName("Convert Address Model By Input Should Return Input When Model Is Null")
    @Test void from_whenModelIsNull() {
        try (MockedStatic<AddressInput> utilities = mockStatic(AddressInput.class)) {
            utilities.when(() -> AddressInput.from(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressInput.from(null));
        }
        assertThrows(InvalidArgumentException.class, () -> AddressInput.from(null));
    }

}