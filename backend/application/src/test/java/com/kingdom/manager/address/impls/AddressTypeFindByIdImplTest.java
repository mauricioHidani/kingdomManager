package com.kingdom.manager.address.impls;

import com.kingdom.manager.address.fatories.AddressTypeFactory;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import com.kingdom.manager.exceptions.InvalidRequestException;
import com.kingdom.manager.exceptions.ResourceNotFoundException;
import com.kingdom.manager.persists.AddressTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeFindByIdImplTest {

    private AddressTypeRepository repository;
    private AddressTypeFindByIdImpl useCase;

    @BeforeEach void setUp() throws Exception {
        repository = Mockito.mock(AddressTypeRepository.class);
        useCase = new AddressTypeFindByIdImpl(repository);
    }

    @DisplayName("Find By Id Should Return Found When Successful Find")
    @Test void execute_whenSuccessfulFind() {
        when(repository.findById(1)).thenReturn(Optional.of(AddressTypeFactory.newModel(1)));

        AddressTypeResponse result = useCase.execute(1);

        verify(repository, times(1)).findById(any(Integer.class));

        assertNotNull(result);
        assertEquals(result.title(), AddressTypeFactory.title());
        assertEquals(result.description(), AddressTypeFactory.description());
    }

    @DisplayName("Find By Id Should Return Invalid Request Exception When Id Is Null")
    @Test void execute_whenIdIsNull() {
        assertThrows(InvalidRequestException.class, () -> useCase.execute(null));
    }

    @DisplayName("Find By Id Should Return Invalid Request Exception When Id Less Then Zero")
    @Test void execute_whenIdLessThenZero() {
        assertThrows(InvalidRequestException.class, () -> useCase.execute(-1));
    }

    @DisplayName("Find By Id Should Return Resource Not Found Exception When Does Not Found")
    @Test void execute_whenDoesNotFound() {
        when(repository.findById(10000)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> useCase.execute(10000));

        verify(repository, times(1)).findById(any(Integer.class));
    }
}