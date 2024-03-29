package com.example.logisticprogram.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "APPLICATION")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "APPLICATION_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Application extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    User manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    User client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_ID")
    Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LIST_DOC_ID")
    ListDoc listDocs;


    public Application(Long id) {
        this.id = id;
    }

    @Override
    public Application setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Application setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Application setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public Application setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Application setDescription(String description) {
        this.description = description;
        return this;
    }

}
