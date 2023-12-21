package com.kingdom.manager.endpoints;

import com.kingdom.manager.address.AddressTypeCreate;
import com.kingdom.manager.address.requests.AddressTypeRequest;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address-types")
public class AddressTypeEndpoint {

    private final AddressTypeCreate create;

    public AddressTypeEndpoint(AddressTypeCreate create) {
        this.create = create;
    }

    @PostMapping
    public ResponseEntity<AddressTypeResponse> create(
            @RequestBody AddressTypeRequest request
    ) {
        return ResponseEntity.ok(create.execute(request));
    }

}
