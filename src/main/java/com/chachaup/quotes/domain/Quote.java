package com.chachaup.quotes.domain;

import lombok.Data;

import javax.persistence.*;

//@Data annotation provides getters and setters and to string methods
@Data @Entity @Table(name = "tbl_quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String quoteMessage;

    private String quoteAuthor;

}
