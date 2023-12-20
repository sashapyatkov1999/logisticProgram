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

@Entity(name = "POINT")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = true)
@ToString(onlyExplicitlyIncluded = true,callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "POINT_ID"))
public class Point extends EntityWithName{

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "point")
    List<Point> points = Collections.emptyList();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    File file;


    public Point(Long id) {
        this.id = id;
    }

    @Override
    public Point setId(Long id) {
        this.id = id;
        return this;
    }

    @ToString.Include
    @Column(name = "START_TIME", nullable = false)
    protected String startTime;// надо исправить на время

    @ToString.Include
    @Column(name = "START_END", nullable = false)
    protected String startEnd;// надо исправить на время

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
