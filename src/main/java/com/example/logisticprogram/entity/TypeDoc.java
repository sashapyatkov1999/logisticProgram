package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "TYPE_DOC")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TYPE_DOC_ID"))
public class TypeDoc extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    public TypeDoc(Long id) {
        this.id = id;
    }

    @Override
    public TypeDoc setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public TypeDoc setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public TypeDoc setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public TypeDoc setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TypeDoc setDescription(String description) {
        this.description = description;
        return this;
    }
}
