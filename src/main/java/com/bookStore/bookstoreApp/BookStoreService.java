package com.bookStore.bookstoreApp;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookStoreService {
    private final BookStoreRepository repo;

    public BookStoreService(BookStoreRepository repo) {
        this.repo = repo;
    }

    public void insertBookStore(Bookstore bookstore) {
        repo.save(bookstore);
    }

    public void updateBookStore(Bookstore bookstore) {
        repo.save(bookstore);
    }

    public void deleteBookStore(Long id) {
        repo.deleteById(id);
    }

    public Bookstore getBookStoreById(long id){
        return repo.findById(id).orElse(null);
    }

    public List<Bookstore> getAllBookStore(Long Keyword){
        if (Keyword!=null)
            return repo.search(Keyword);
        return repo.findAll();
    }
}
