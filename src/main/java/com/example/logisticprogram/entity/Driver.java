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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "DRIVER")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "DRIVER_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Driver extends BaseEntity {

    @Serial
    static final long serialVersionUID = 1L;

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
    String passportNumber;

    @ToString.Include
    @Column(name = "PASSPORT_DATE", nullable = false, updatable = false)
    LocalDate passportDate;

    @ToString.Include
    @Column(name = "REGISTRATION", nullable = false, updatable = false)
    String passportRegistration;

    @ToString.Include
    @Column(name = "DRIVE_LICENSE", nullable = false)
    String driverLicense;


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
