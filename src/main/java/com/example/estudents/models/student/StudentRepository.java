package com.example.estudents.models.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET status = :status WHERE id= :id", nativeQuery = true)
    Integer updateStatusById(
            @Param("status") Boolean status,
            @Param("id")Long id);
    boolean existsByCurp (String curp);

    @Query(value = "SELECT id FROM tabla ORDER BY ID DESC LIMIT 1", nativeQuery = true)
    int getlast();
}
