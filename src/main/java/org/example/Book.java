package org.example;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Getter
@ToString
public class Book {

    private String title;

    private String author;

    private int publication;

    private int pages;

    private double rating;

    public Book(String title, String author, int publication, double rating, int pages) {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.pages = pages;
        this.rating = rating;
    }





//     Find the average rating of all book



}
