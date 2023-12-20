package com.kingdom.manager.models;

import java.util.Set;
import java.util.UUID;

public record Person(
        UUID id,
        String fullname,
        String document,
        PersonType type,
        Set<Address> addresses,
        Set<Contact> contacts
) {
}
