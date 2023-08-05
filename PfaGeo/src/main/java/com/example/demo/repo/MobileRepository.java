package com.example.demo.repo;

import com.example.demo.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MobileRepository extends JpaRepository<Mobile, Long> {
    @Query(value = "SELECT * FROM mobile WHERE processed = false", nativeQuery = true)
    List<Mobile> findUnprocessedEntries();
}
