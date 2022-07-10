package com.chachaup.quotes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

//@Data annotation provides getters and setters and to string methods
@Data @NoArgsConstructor
@Entity @Table(name = "tbl_quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String quoteMessage;

    @NonNull
    private String quoteAuthor;

}
