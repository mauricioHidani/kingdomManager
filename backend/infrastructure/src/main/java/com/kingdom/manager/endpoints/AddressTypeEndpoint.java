package com.kingdom.manager.endpoints;

import com.kingdom.manager.address.requests.AddressTypeRequest;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import com.kingdom.manager.services.AddressTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address-types")
public class AddressTypeEndpoint {

    private final AddressTypeService service;

    public AddressTypeEndpoint(AddressTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddressTypeResponse> create(
            @RequestBody AddressTypeRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressTypeResponse> findById(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<AddressTypeResponse> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.findByTitle(title));
    }

}
