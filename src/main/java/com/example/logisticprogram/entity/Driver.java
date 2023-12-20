package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

@Entity(name = "DRIVER")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "DRIVER_ID"))
public class Driver extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_SRATUS_ID")
    DriverStatus driverStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    Car car;

    @ToString.Include
    @Column(name = "PASSPORT_NUMBER", nullable = false, updatable = false)
    protected Integer passportNumber; // надо логику проделать типа (#### #####)

    @ToString.Include
    @Column(name = "PASSPORT_DATE", nullable = false, updatable = false)
    protected Integer passportDate; // ##.##.####

    @ToString.Include
    @Column(name = "PASSPORT_REGISTRATION", nullable = false, updatable = false)
    protected String passportRegistration;

    @ToString.Include
    @Column(name = "DRIVER_LICENSE", nullable = false)
    protected String driverLicense;

}
