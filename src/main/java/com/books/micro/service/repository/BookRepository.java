package com.books.micro.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PlotLandRepository
 */
@Repository
public interface BookRepository extends JpaRepository<com.books.micro.service.model.Book, Long> {

}
