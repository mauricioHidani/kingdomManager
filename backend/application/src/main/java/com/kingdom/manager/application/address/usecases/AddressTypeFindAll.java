package com.kingdom.manager.application.address.usecases;

import com.kingdom.manager.application.address.out.AddressTypeOutput;

import java.util.List;

public interface AddressTypeFindAll {
    List<AddressTypeOutput> execute();
}
