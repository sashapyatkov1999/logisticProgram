package com.example.logisticprogram.repository;



import com.example.logisticprogram.entity.TypeDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDocRepository extends JpaRepository<TypeDoc, Long> {
}
