package com.example.logisticprogram.repository;

import com.example.logisticprogram.entity.ListDoc;
import com.example.logisticprogram.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface listDocRepository extends JpaRepository<ListDoc, Long> {

}
