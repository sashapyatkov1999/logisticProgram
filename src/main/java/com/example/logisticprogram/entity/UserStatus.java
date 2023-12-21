package com.example.logisticprogram.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "USER_STATUS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_STATUS_ID"))

public class UserStatus extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserStatus(Long id) {
        this.id = id;
    }

    @Override
    public UserStatus setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserStatus setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public UserStatus setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public UserStatus setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserStatus setDescription(String description) {
        this.description = description;
        return this;
    }
}
