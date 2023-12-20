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

@Entity(name = "DRIVER_STATUS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "DRIVER_STATUS_ID"))
public class DriverStatus  extends EntityWithName{

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driverStatus")
    List<DriverStatus> driverStatuses = Collections.emptyList();

    public DriverStatus(Long id){
        this.id=id;
    }

    @Override
    public DriverStatus setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public DriverStatus setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public DriverStatus setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public DriverStatus setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public DriverStatus setName(String name) {
        this.name = name;
        return this;
    }
}
