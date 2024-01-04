package com.kingdom.manager.infrastructure.address.endpoints;

import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.infrastructure.address.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressEndpoint {

    private final AddressService service;

    public AddressEndpoint(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddressOutput> create(@RequestBody AddressInput input) {
        var result = service.create(input);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressOutput> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
