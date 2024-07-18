package com.bookStore.bookstoreApp;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreRepository extends JpaRepository<Bookstore,Long> {
    @Query(value = "Select * from bookstore where id =?1", nativeQuery = true)
    public List<Bookstore> search(@Param("Keyword") Long id);
}
