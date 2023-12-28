package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "APPLICATION_CLIENT")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "APPLICATION__CLIENT_ID"))
public class ApplicationClient extends EntityWithName {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    Application application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    User client;


    public ApplicationClient(Long id) {
        this.id = id;
    }

    @Override
    public ApplicationClient setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public ApplicationClient setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public ApplicationClient setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }


    @Override
    public ApplicationClient setDescription(String description) {
        this.description = description;
        return this;
    }
}
