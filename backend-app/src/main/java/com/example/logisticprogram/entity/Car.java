package com.example.logisticprogram.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "CAR")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "CAR_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @ToString.Include
    @Column(name = "CAR_NUMBER", nullable = false, updatable = false)
    String carNumber;

    @ToString.Include
    @Column(name = "TRAILER_NUMBER", nullable = false, updatable = false)
    String trailerNumber;

    public Car(Long id) {
        this.id = id;
    }

    @Override
    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Car setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }


    @Override
    public Car setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }


}
