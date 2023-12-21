package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "USERS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USERS"))
public class User extends  BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_STATUS_ID")
    UserStatus status;

    @ToString.Include
    @Column(name = "SURNAME", nullable = false, updatable = false)
    protected String surname;

    @ToString.Include
    @Column(name = "NAME")
    protected String name;

    @ToString.Include
    @Column(name = "PASSWORD", nullable = false, updatable = false)
    protected String password;

    @ToString.Include
    @Column(name = "LOGIN", nullable = false, updatable = false)
    protected String login;

    @ToString.Include
    @Column(name = "E-MAIL", nullable = false, updatable = false)
    protected String email;

    @ToString.Include
    @Column(name = "PHONE_NUMBER", nullable = false, updatable = false)
    protected Long phoneNumber;


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
