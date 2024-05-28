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

@Entity(name = "FILE")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "FILE_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class File extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    Application application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POINT_ID")
    Point point;

    public File(Long id) {
        this.id = id;
    }

    @Override
    public File setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public File setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public File setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public File setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public File setDescription(String description) {
        this.description = description;
        return this;
    }

}
