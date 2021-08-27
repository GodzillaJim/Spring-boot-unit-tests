package com.godzillajim.unittestingintegration.entities.library;

import com.godzillajim.unittestingintegration.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Data
public class Book extends BaseEntity {
    private String isbn;
    private String aisle;
    private String author;
    private String title;
    private String tags;
}
