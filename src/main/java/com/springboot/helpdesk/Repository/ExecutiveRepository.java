package com.springboot.helpdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.helpdesk.model.Executive;

@Repository
public interface ExecutiveRepository extends JpaRepository<Executive, Long> {
}