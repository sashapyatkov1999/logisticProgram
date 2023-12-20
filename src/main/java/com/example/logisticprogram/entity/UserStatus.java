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

@Entity(name = "USER_STATUS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_STATUS_ID"))

public class UserStatus extends EntityWithName{

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersStatus")
    List<UserStatus> userStatuses = Collections.emptyList();


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
