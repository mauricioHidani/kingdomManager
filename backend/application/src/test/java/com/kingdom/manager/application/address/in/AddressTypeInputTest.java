package com.kingdom.manager.application.address.in;

import com.kingdom.manager.application.address.factories.AddressTypeFactory;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

class AddressTypeInputTest {

    private AddressType newModel;
    private AddressType modelWithId;
    private AddressTypeOutput output;
    private AddressTypeInput input;

    @BeforeEach void setUp() {
        newModel = AddressTypeFactory.newModel();
        modelWithId = AddressTypeFactory.newModel(1);
        output = AddressTypeFactory.newOutput();
        input = AddressTypeFactory.newInput();
    }

    @DisplayName("Convert Address Type Input Model By Model Should Return Model When Successful Convert")
    @Test void toModel_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toModel(input)).thenReturn(newModel);
            assertEquals(AddressTypeInput.toModel(input), newModel);
        }

        assertEquals(AddressTypeInput.toModel(input), newModel);
    }

    @DisplayName("Convert Address Type Output Model By Model Should Return Invalid Argument Exception When Null Argument")
    @Test void toModel_whenNullArgument() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toModel(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(null));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(null));
    }

    @DisplayName("Convert Address Type Input Model By Model With Id Should Return Model When Successful Convert")
    @Test void toModelWithId_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toModel(1, input)).thenReturn(modelWithId);
            assertEquals(AddressTypeInput.toModel(1, input), modelWithId);
        }

        assertEquals(AddressTypeInput.toModel(1, input), modelWithId);
    }

    @DisplayName("Convert Address Type Input Model By Model With Id Should Return Invalid Argument Exception When Id Is Null")
    @Test void toModelWithId_whenIdIsNull() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toModel(null, input)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(null, input));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(null, input));
    }

    @DisplayName("Convert Address Type Input Model By Model With Id Should Return Invalid Argument Exception When Id Less Then Zero")
    @Test void toModelWithId_whenIdLessThenZero() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toModel(-1, input)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(-1, input));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(-1, input));
    }

    @DisplayName("Convert Address Type Input Model By Model With Id Should Return Invalid Argument Exception When Output Is Null")
    @Test void toModelWithId_whenOutputIsNull() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toModel(1, null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(1, null));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toModel(1, null));
    }

    @DisplayName("Convert Address Type Input Model By Output Model Should Return Input When Successful Convert")
    @Test void toInput_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toOutput(input)).thenReturn(output);
            assertEquals(AddressTypeInput.toOutput(input), output);
        }

        assertEquals(AddressTypeInput.toOutput(input), output);
    }

    @DisplayName("Convert Address Type Input Model By Output Model Should Return Invalid Argument Exception When Output Is Null")
    @Test void toInput_whenOutputIsNull() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.toOutput(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toOutput(null));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeInput.toOutput(null));
    }

    @DisplayName("Convert Address Type Model By Input Model Should Return Output Model When Successful Convert")
    @Test void from_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.from(modelWithId)).thenReturn(input);
            assertEquals(AddressTypeInput.from(modelWithId), input);
        }

        assertEquals(AddressTypeInput.from(modelWithId), input);
    }

    @DisplayName("Convert Address Type Model By Input Model Should Return Invalid Argument Exception When Model Is Null")
    @Test void from_whenModelIsNull() {
        try (MockedStatic<AddressTypeInput> utilities = mockStatic(AddressTypeInput.class)) {
            utilities.when(() -> AddressTypeInput.from(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () ->  AddressTypeInput.from(null));
        }

        assertThrows(InvalidArgumentException.class, () ->  AddressTypeInput.from(null));
    }
}