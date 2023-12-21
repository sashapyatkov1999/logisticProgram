package com.example.logisticprogram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "LIST_DOCS")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "LIST_DOCS_ID"))
public class ListDocs extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    Application application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_DOCS_ID")
    TypeDoc typeDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POINT_ID")
    Point point;

    public ListDocs(Long id) {
        this.id = id;
    }

    @Override
    public ListDocs setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public ListDocs setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public ListDocs setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
}
