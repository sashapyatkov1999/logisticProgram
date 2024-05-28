package com.example.logisticprogram.repository;

import com.example.logisticprogram.entity.ListDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListDocRepository extends JpaRepository<ListDoc, Long> {

}
