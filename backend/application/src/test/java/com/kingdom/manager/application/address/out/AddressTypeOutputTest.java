package com.kingdom.manager.application.address.out;

import com.kingdom.manager.application.address.factories.AddressTypeFactory;
import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

class AddressTypeOutputTest {

    private AddressType newModel;
    private AddressType modelWithId;
    private AddressTypeOutput output;
    private AddressTypeInput input;

    @BeforeEach void setUp() throws Exception {
        newModel = AddressTypeFactory.newModel();
        modelWithId = AddressTypeFactory.newModel(1);
        output = AddressTypeFactory.newOutput();
        input = AddressTypeFactory.newInput();
    }

    @DisplayName("Convert Address Type Output Model By Model Should Return Model When Successful Convert")
    @Test void toModel_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toModel(output)).thenReturn(newModel);
            assertEquals(AddressTypeOutput.toModel(output), newModel);
        }

        assertEquals(AddressTypeOutput.toModel(output), newModel);
    }

    @DisplayName("Convert Address Type Output Model By Model Should Return Invalid Argument Exception When Null Argument")
    @Test void toModel_whenNullArgument() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toModel(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(null));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(null));
    }

    @DisplayName("Convert Address Type Output Model By Model With Id Should Return Model When Successful Convert")
    @Test void toModelWidthId_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toModel(1, output)).thenReturn(modelWithId);
            assertEquals(AddressTypeOutput.toModel(1, output), modelWithId);
        }

        assertEquals(AddressTypeOutput.toModel(1, output), modelWithId);
    }

    @DisplayName("Convert Address Type Output Model By Model With Id Should Return Invalid Argument Exception When Id Is Null")
    @Test void toModelWithId_whenIdIsNull() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toModel(null, output)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(null, output));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(null, output));
    }

    @DisplayName("Convert Address Type Output Model By Model With Id Should Return Invalid Argument Exception When Id Less Then Zero")
    @Test void toModelWithId_whenIdLessThenZero() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toModel(-1, output)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(-1, output));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(-1, output));
    }

    @DisplayName("Convert Address Type Output Model By Model With Id Should Return Invalid Argument Exception When Output Is Null")
    @Test void toModelWithId_whenOutputIsNull() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toModel(1, null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(1, null));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toModel(1, null));
    }

    @DisplayName("Convert Address Type Output Model By Input Model Should Return Input When Successful Convert")
    @Test void toInput_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toInput(output)).thenReturn(input);
            assertEquals(AddressTypeOutput.toInput(output), input);
        }

        assertEquals(AddressTypeOutput.toInput(output), input);
    }

    @DisplayName("Convert Address Type Output Model By Input Model Should Return Invalid Argument Exception When Output Is Null")
    @Test void toInput_whenOutputIsNull() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.toInput(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toInput(null));
        }

        assertThrows(InvalidArgumentException.class, () -> AddressTypeOutput.toInput(null));
    }

    @DisplayName("Convert Address Type Model By Output Model Should Return Output Model When Successful Convert")
    @Test void from_whenSuccessfulConvert() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.from(modelWithId)).thenReturn(output);
            assertEquals(AddressTypeOutput.from(modelWithId), output);
        }

        assertEquals(AddressTypeOutput.from(modelWithId), output);
    }

    @DisplayName("Convert Address Type Model By Output Model Should Return Invalid Argument Exception When Model Is Null")
    @Test void from_whenModelIsNull() {
        try (MockedStatic<AddressTypeOutput> utilities = mockStatic(AddressTypeOutput.class)) {
            utilities.when(() -> AddressTypeOutput.from(null)).thenThrow(InvalidArgumentException.class);
            assertThrows(InvalidArgumentException.class, () ->  AddressTypeOutput.from(null));
        }

        assertThrows(InvalidArgumentException.class, () ->  AddressTypeOutput.from(null));
    }
}