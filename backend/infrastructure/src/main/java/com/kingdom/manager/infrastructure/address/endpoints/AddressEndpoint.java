package com.kingdom.manager.infrastructure.address.endpoints;

import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.infrastructure.address.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressEndpoint {

    private final AddressService service;

    public AddressEndpoint(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddressOutput> create(@RequestBody AddressInput input) {
        return ResponseEntity.ok(service.create(input));
    }

}
