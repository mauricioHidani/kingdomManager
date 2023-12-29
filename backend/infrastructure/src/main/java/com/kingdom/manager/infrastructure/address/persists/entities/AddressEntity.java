package com.kingdom.manager.infrastructure.address.persists.entities;

import com.kingdom.manager.domain.address.models.AddressType;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "addresses")
public class AddressEntity implements Serializable {

    @Serial private static final long serialVersionUID = -4128570639642172734L;

    // region Attributes
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "addresses_has_types",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<AddressTypeEntity> types = new HashSet<AddressTypeEntity>();

    @Column(length = 128, nullable = false)
    private String publicPlace;

    @Column(length = 6, nullable = false)
    private String number;

    @Column(length = 64)
    private String complement;

    @Column(length = 128, nullable = false)
    private String neighborhood;

    @Column
    private String city;

    @Column(length = 2)
    private String state;

    @Column(length = 2)
    private String country;

    @Column(length = 14, nullable = false)
    private String zipcode;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate register;

    @ManyToOne
    @JoinTable(
            name = "persons_has_addresses",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private PersonEntity owner;
    // endregion

    // region Constructors
    public AddressEntity() {
    }

    public AddressEntity(Set<AddressTypeEntity> types, String publicPlace, String number, String complement,
                         String neighborhood, String city, String state, String country, String zipcode,
                         LocalDate register, PersonEntity owner) {
        this.types = types;
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.register = register;
        this.owner = owner;
    }

    public AddressEntity(UUID id, Set<AddressTypeEntity> types, String publicPlace, String number, String complement,
                         String neighborhood, String city, String state, String country, String zipcode,
                         LocalDate register, PersonEntity owner) {
        this.id = id;
        this.types = types;
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.register = register;
        this.owner = owner;
    }
    // endregion

    // region Access Methods
    public UUID getId() {
        return id;
    }

    public Set<AddressTypeEntity> getTypes() {
        return types;
    }

    public void addType(AddressTypeEntity type) {
        this.types.add(type);
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public LocalDate getRegister() {
        return register;
    }

    public PersonEntity getOwner() {
        return owner;
    }
    // endregion

    // region Equals And Hash Code
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(types, that.types) &&
                Objects.equals(publicPlace, that.publicPlace) &&
                Objects.equals(number, that.number) &&
                Objects.equals(neighborhood, that.neighborhood) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(register, that.register);
    }

    @Override public int hashCode() {
        return Objects.hash(id, types, publicPlace, number, neighborhood, zipcode, register);
    }
    // endregion

}
