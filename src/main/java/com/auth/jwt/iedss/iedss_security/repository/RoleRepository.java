package com.auth.jwt.iedss.iedss_security.repository;

import java.util.Optional;

import com.auth.jwt.iedss.iedss_security.models.ERole;
import com.auth.jwt.iedss.iedss_security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}