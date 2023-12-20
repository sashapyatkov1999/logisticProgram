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

@Entity(name = "USERS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USERS"))
public class Users extends  EntityWithName {
    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    List<Users> userses = Collections.emptyList();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    File file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ROLE_ID")
    Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    Application application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_ID")
    Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_CLIENT_ID")
    ApplicationClient applicationClient;


    public Users(Long id) {
        this.id = id;
    }

    @Override
    public Users setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Users setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @ToString.Include
    @Column(name = "SURNAME", nullable = false, updatable = false)
    protected String surname;

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

    @Override
    public Users setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public Users setName(String name) {
        this.name = name;
        return this;
    }
}
