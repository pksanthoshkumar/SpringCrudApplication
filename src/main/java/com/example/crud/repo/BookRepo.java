package com.example.crud.repo;

import com.example.crud.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends  JpaRepository<Books, Long> {
}
