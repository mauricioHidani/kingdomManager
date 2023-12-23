package com.kingdom.manager.infrastructure.address.endpoints;

import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.infrastructure.address.services.AddressTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address-types")
public class AddressTypeEndpoint {

    private final AddressTypeService service;

    public AddressTypeEndpoint(AddressTypeService service) {
        this.service = service;
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<AddressTypeOutput> findByTitle(
            @PathVariable String title
    ) {
        return ResponseEntity.ok(
                service.findByTitle(title)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressTypeOutput> findById(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<AddressTypeOutput>> findAll() {
        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @PostMapping
    public ResponseEntity<AddressTypeOutput> create(
            @RequestBody AddressTypeInput input
    ) {
        var result = service.create(input);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/title/{title}")
                .buildAndExpand(result.title())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id
    ) {
        service.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressTypeOutput> update(
            @PathVariable Integer id,
            @RequestBody AddressTypeInput input
    ) {
        return ResponseEntity.ok(
                service.update(id, input)
        );
    }

}
