package com.example.logisticprogram.repository;

import com.example.logisticprogram.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {

    UserStatus findUserStatusByName(String name);
    UserStatus getAllById(Long id);

}
