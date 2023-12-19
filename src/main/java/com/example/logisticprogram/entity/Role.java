package com.example.logisticprogram.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "ROLE")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "ROLE_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends EntityWithName {


    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    List<Role> userRoles = Collections.emptyList();


    public Role(Long id) {
        this.id = id;
    }

    @Override
    public Role setId(Long id) {
       this.id = id;
       return this;
    }

    @Override
    public Role setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Role setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public Role setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Role setDescription(String description) {
        this.description = description;
        return this;
    }
}
