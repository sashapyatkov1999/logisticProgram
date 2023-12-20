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

@Entity(name = "TYPE_DOCS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TYPE_DOCS_ID"))
public class TypeDocs extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeDocses")
    List<TypeDocs> typeDocs = Collections.emptyList();


    public TypeDocs(Long id) {
        this.id = id;
    }

    @Override
    public TypeDocs setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public TypeDocs setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public TypeDocs setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public TypeDocs setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TypeDocs setDescription(String description) {
        this.description = description;
        return this;
    }
}
