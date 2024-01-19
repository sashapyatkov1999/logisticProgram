package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "DRIVER_STATUS_ID")
    DriverStatus driverStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    User user;

    @ToString.Include
    @Column(name = "PASSPORT_NUMBER", nullable = false, updatable = false)
    private String passportNumber;

    @ToString.Include
    @Column(name = "PASSPORT_DATE", nullable = false, updatable = false)
    private LocalDate passportDate;

    @ToString.Include
    @Column(name = "REGISTRATION", nullable = false, updatable = false)
    private String passportRegistration;

    @ToString.Include
    @Column(name = "DRIVER_LICENSE", nullable = false)
    private String driverLicense;


    public Driver(Long id) {
        this.id = id;
    }

    @Override
    public Driver setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Driver setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }


    @Override
    public Driver setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

}
