package com.godzillajim.unittestingintegration.entities.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String aisle;
    private String author;
    private String isbn;
    private String tags;
    private String title;
}
