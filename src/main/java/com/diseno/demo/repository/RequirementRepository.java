package com.diseno.demo.repository;

import com.diseno.demo.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    //HashSet<Requirement> findAllByIds(HashSet<Long> requirementsIds);
}
