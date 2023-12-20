package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "APPLICATION")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = true)
@ToString(onlyExplicitlyIncluded = true,callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "APPLICATION_ID"))
public class Application extends EntityWithName{

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_CLIENT_ID")
    ApplicationClient applicationClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_ID")
    Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LIST_DOCS_ID")
    ListDocs listDocs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POINT_ID")
    Point point;

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
