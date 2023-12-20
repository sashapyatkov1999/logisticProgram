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

@Entity(name = "FILE")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = true)
@ToString(onlyExplicitlyIncluded = true,callSuper = true)
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "FILE_ID"))
public class File extends EntityWithName{

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "file")
    List<File> files = Collections.emptyList();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "point")
    List<File> filesToPoint = Collections.emptyList();
    public File(Long id) {
        this.id = id;
    }

    @Override
    public File setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public File setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public File setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public File setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public File setDescription(String description) {
        this.description = description;
        return this;
    }

}
