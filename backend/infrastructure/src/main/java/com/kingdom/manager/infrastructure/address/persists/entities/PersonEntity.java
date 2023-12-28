package com.kingdom.manager.infrastructure.address.persists.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class PersonEntity implements Serializable {

    @Serial private static final long serialVersionUID = 580378355892635956L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false, unique = true)
    private String document;

    public PersonEntity() {
    }

    public PersonEntity(String fullname, String document) {
        this.fullname = fullname;
        this.document = document;
    }

    public PersonEntity(UUID id, String fullname, String document) {
        this.id = id;
        this.fullname = fullname;
        this.document = document;
    }

    public UUID getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDocument() {
        return document;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fullname, that.fullname) &&
                Objects.equals(document, that.document);
    }

    @Override public int hashCode() {
        return Objects.hash(id, fullname, document);
    }

}
