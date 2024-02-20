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

@Entity(name = "USERS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_STATUS_ID")
    UserStatus status;

    @ToString.Include
    @Column(name = "SURNAME", nullable = false, updatable = false)
    String surname;

    @ToString.Include
    @Column(name = "NAME")
    String name;

    @ToString.Include
    @Column(name = "PASSWORD", nullable = false, updatable = false)
    String password;

    @ToString.Include
    @Column(name = "LOGIN", nullable = false, updatable = false)
    String login;

    @ToString.Include
    @Column(name = "E_MAIL", nullable = false, updatable = false)
    String email;

    @ToString.Include
    @Column(name = "PHONE_NUMBER", nullable = false, updatable = false)
    String phoneNumber;


    public User(Long id) {
        this.id = id;
    }

    @Override
    public User setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public User setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }


    @Override
    public User setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }


}
