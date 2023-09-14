package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {
    public static void main(String[] args) {



        // Create a collection of Book objects to work with. You can either create a sample dataset or read data from a file or database.

        List<Book> books = new ArrayList<>();

        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 5, 1178));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 6, 310));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 4, 223));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 4, 251));
        books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 4, 317));
        books.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000, 7, 636));
        books.add(new Book("Kafka on the Shore", "Haruki Murakami", 2002, 10, 505));
        books.add(new Book("The Wind-Up Bird Chronicle", "Haruki Murakami", 1994, 4, 607));
        books.add(new Book("1Q84", "Haruki Murakami", 2009, 3, 925));

        for( Book book :books ){
            System.out.println(books.toString());
        }

        // Find the average rating of all books

        double average = books.stream()
                .mapToDouble(book -> book.getRating())
                .average()
                .getAsDouble();

        System.out.println("Average rating of all books: " + average);

        //Filter and display books published after a specific year.

        int year = 1994;

        double booksPublishedAfterYear = books.stream().filter(book -> book.getPublication() > year).count();

        System.out.println("Books published after " + year + ": " + booksPublishedAfterYear);


        // Sort books by rating in descending order

        books.stream().sorted(Comparator.comparing(Book::getRating).reversed()).forEach(System.out::println);

        // Find and display the title of the book with the highest rating

         String highestRating = books.stream().max(Comparator.comparing(Book::getRating)).get().getTitle();

            System.out.println("Book with highest rating: " + highestRating);

            // Group books by author and calculate the average rating for each author's books.

        String groupByAuthorAndAverageRating = books.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getRating))).toString();
        System.out.println("Group by author and average rating: " + groupByAuthorAndAverageRating);

        // Calculate the total number of pages for all books (assuming each book has a fixed number of pages).

        int totalNumberOfPages = books.stream().mapToInt(Book::getPages).sum();
        System.out.println("Total number of pages: " + totalNumberOfPages);

        // Chain multiple Stream operations together to perform complex tasks, such as filtering and sorting.

       books.stream().filter(book -> book.getPublication() > 1994)
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .forEach(System.out::println);

        System.out.println("Books published after 1994 and sorted by rating in descending order: " + books);




    }
}