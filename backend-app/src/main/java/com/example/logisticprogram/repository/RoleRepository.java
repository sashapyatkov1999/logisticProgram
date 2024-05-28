package com.example.logisticprogram.repository;

import com.example.logisticprogram.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName (String name);


    @Query(nativeQuery = true, value = "SELECT * FROM REPOSITORY.ROLE WHERE NAME = :name")
    Role findRoleByName2(@Param("name") String name);
}
