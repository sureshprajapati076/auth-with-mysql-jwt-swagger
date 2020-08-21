package com.example.jwtdemo.repository;

import com.example.jwtdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.StoredProcedureParameter;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
