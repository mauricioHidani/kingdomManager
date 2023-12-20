package com.kingdom.manager.address.impls;

import com.kingdom.manager.address.fatories.AddressTypeFactory;
import com.kingdom.manager.exceptions.DatabaseException;
import com.kingdom.manager.exceptions.DatabaseIntegrityException;
import com.kingdom.manager.models.AddressType;
import com.kingdom.manager.persists.AddressTypeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AddressTypeCreateImplTest {

    private AddressTypeRepository repository;
    private AddressTypeCreateImpl useCase;

    @BeforeEach void setUp() throws Exception {
        repository = Mockito.mock(AddressTypeRepository.class);
        useCase = new AddressTypeCreateImpl(repository);
    }

    @AfterEach void tearDown() throws Exception {
    }

    @DisplayName("Save Address Type Should Return Saved When Successful Save")
    @Test void execute_whenSuccessfulSave() {
        when(repository.existingByTitle(AddressTypeFactory.title())).thenReturn(false);
        when(repository.save(AddressTypeFactory.newModel())).thenReturn(AddressTypeFactory.newModel(1));

        var result = useCase.execute(AddressTypeFactory.newRequest());

        verify(repository, times(1)).existingByTitle(any(String.class));
        verify(repository, times(1)).save(any(AddressType.class));

        assertNotNull(result);
        assertEquals(result.title(), AddressTypeFactory.title());
        assertEquals(result.description(), AddressTypeFactory.description());
    }

    @DisplayName("Save address Type Should Return Database Integrity Exception When Address Exist")
    @Test void execute_whenAddressExist() {
        when(repository.existingByTitle(AddressTypeFactory.title())).thenReturn(true);
        assertThrows(DatabaseIntegrityException.class, () -> useCase.execute(AddressTypeFactory.newRequest()));

        verify(repository, times(1)).existingByTitle(AddressTypeFactory.title());
    }

    @DisplayName("Save Address Type Should Return Dabase Exception When Does Not Save")
    @Test void execute_whenDoesNotSave() {
        when(repository.existingByTitle(AddressTypeFactory.title())).thenReturn(false);
        when(repository.save(AddressTypeFactory.newModel())).thenReturn(null);
        assertThrows(DatabaseException.class, () -> useCase.execute(AddressTypeFactory.newRequest()));

        verify(repository, times(1)).existingByTitle(any(String.class));
        verify(repository, times(1)).save(any(AddressType.class));
    }
}