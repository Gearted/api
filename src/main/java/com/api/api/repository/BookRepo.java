package com.api.api.repository;

import com.api.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepo extends JpaRepository<Book, Long> {

}

