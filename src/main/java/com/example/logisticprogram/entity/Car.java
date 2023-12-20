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

@Entity(name = "CAR")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "CAR_ID"))
public class Car extends  BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    List<Car> cars = Collections.emptyList();

    public Car(Long id) {
        this.id = id;
    }

    @ToString.Include
    @Column(name = "CAR_NUMBER", nullable = false, updatable = false)
    protected String carNumber;

    @ToString.Include
    @Column(name = "TRAILER_NUMBER", nullable = false, updatable = false)
    protected String trailerNumber;


}
