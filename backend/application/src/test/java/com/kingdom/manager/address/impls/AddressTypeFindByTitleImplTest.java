package com.kingdom.manager.address.impls;

import com.kingdom.manager.address.fatories.AddressTypeFactory;
import com.kingdom.manager.exceptions.InvalidRequestException;
import com.kingdom.manager.exceptions.ResourceNotFoundException;
import com.kingdom.manager.persists.AddressTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeFindByTitleImplTest {

    private AddressTypeRepository repository;
    private AddressTypeFindByTitleImpl useCase;

    @BeforeEach void setUp() throws Exception {
        repository = Mockito.mock(AddressTypeRepository.class);
        useCase = new AddressTypeFindByTitleImpl(repository);
    }

    @DisplayName("Find By Title Should Return Found When Successful Find")
    @Test void execute_whenSuccessfulFind() {
        when(repository.findByTitle(AddressTypeFactory.title())).thenReturn(AddressTypeFactory.newModel(1));

        var result = useCase.execute(AddressTypeFactory.title());

        assertNotNull(result);
        assertEquals(result.title(), AddressTypeFactory.title());
        assertEquals(result.description(), AddressTypeFactory.description());
    }

    @DisplayName("Find By Title Should Return Invalid Request Exception When Title Is Blank")
    @Test void execute_whenTitleIsBlank() {
        assertThrows(InvalidRequestException.class, () -> useCase.execute(""));
    }

    @DisplayName("Find By Title Should Return Resource Not Found Exception When Not Found")
    @Test void execute_whenNotFound() {
        when(repository.findByTitle(AddressTypeFactory.title())).thenReturn(null);
        assertThrows(ResourceNotFoundException.class, () -> useCase.execute(AddressTypeFactory.title()));

        verify(repository, times(1)).findByTitle(any(String.class));
    }
}