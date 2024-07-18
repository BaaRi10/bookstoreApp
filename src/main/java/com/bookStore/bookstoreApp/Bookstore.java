package com.bookStore.bookstoreApp;
import jakarta.persistence.*;
import lombok.*;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    @Entity
    @Table(name = "Bookstore")
    public class Bookstore {

        @Id
        private Long id;
        @Column(nullable = false, length = 50)
        private String name;
        private String author;
        private double price;
    }

