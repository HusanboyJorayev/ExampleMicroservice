package com.example.second.repository;


import com.example.second.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByIdAndDeletedAtIsNull(Integer id);


    @Query(
            nativeQuery = true,
            value = "select * from category"
    )
    List<Category> getAllByQuery();

    Page<Category> findAllByDeletedAtIsNull(Pageable pageable);
}
