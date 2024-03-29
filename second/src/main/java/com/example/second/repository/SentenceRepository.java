package com.example.second.repository;


import com.example.second.entity.Sentence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence,Integer> {
    Optional<Sentence> findByIdAndDeletedAtIsNull(Integer id);


    @Query(
            nativeQuery = true,
            value = "select * from sentence"
    )
    List<Sentence> getAllByQuery();

    Page<Sentence> findAllByDeletedAtIsNull(Pageable pageable);
}
