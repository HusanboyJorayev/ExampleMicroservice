package com.example.first.repository;

import com.example.first.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {
    Optional<Note> findByIdAndDeletedAtIsNull(Integer id);


    @Query(
            nativeQuery = true,
            value = "select * from note"
    )
    List<Note> getAllByQuery();

    Page<Note> findAllByDeletedAtIsNull(Pageable pageable);
}
