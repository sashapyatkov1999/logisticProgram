package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "APPLICATION_CLIENT")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "APPLICATION_CLIENT_ID"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationClient extends EntityWithName{

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationClient")
    List<ApplicationClient> applicationClients = Collections.emptyList();


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
