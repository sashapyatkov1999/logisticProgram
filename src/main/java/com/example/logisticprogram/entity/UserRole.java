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

@Entity(name = "USER_ROLE")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_ROLE_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRole extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserRole(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    User user;

    @Override
    public UserRole setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserRole setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
}
