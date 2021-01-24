package com.newjerseysoftware.hederaDemo.repository;

import com.newjerseysoftware.hederaDemo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
}
