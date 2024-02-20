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

@Entity(name = "POINT")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "POINT_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Point extends EntityWithName {

    @Serial
    static final long serialVersionUID = 1L;

    @ToString.Include
    @Column(name = "ORDINAL")
    Long ordinal;

    @ToString.Include
    @Column(name = "FIELD")
    String field;

    @ToString.Include
    @Column(name = "STATUS_OF_ORDINAL_WITH_GEO")
    Boolean statusOfOrdinalWithGeo;


    @ToString.Include
    @Column(name = "TIME_START", nullable = false)
    LocalDateTime timeStart;


    @ToString.Include
    @Column(name = "TIME_END", nullable = false)
    LocalDateTime timeEnd;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    Application application;


    public Point(Long id) {
        this.id = id;
    }

    @Override
    public Point setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Point setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Point setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public Point setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Point setDescription(String description) {
        this.description = description;
        return this;
    }
}
