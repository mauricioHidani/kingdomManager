package com.kingdom.manager.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "address_types")
public class AddressTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, unique = true, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    protected AddressTypeEntity() {
    }

    public AddressTypeEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public AddressTypeEntity(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressTypeEntity that = (AddressTypeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override public int hashCode() {
        return Objects.hash(id, title);
    }
}
