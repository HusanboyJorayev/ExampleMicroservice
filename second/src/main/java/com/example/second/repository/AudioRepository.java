package com.example.second.repository;

import com.example.second.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AudioRepository extends JpaRepository<Audio,Integer> {

    Optional<Audio> findByIdAndDeletedAtIsNull(Integer id);
}
