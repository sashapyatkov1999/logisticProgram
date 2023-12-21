package com.example.logisticprogram.entity;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "POINT")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "POINT_ID"))
public class Point extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    @ToString.Include
    @Column(name = "ORDINAL")
    private Long ordinal;

    @ToString.Include
    @Column(name = "FIELD")
    private String field;

    @ToString.Include
    @Column(name = "STATUS_OF_ORDINAL_WITH_GEO")
    private Boolean statusOfOrdinalWithGeo;


    @ToString.Include
    @Column(name = "TIME_START", nullable = false)
    protected LocalDateTime timeStart;


    @ToString.Include
    @Column(name = "TIME_END", nullable = false)
    protected LocalDateTime timeEnd;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    private Application application;


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
