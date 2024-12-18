package com.diseno.demo.repository;

import com.diseno.demo.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    @Query("SELECT r FROM Requirement r WHERE r.id IN :requirementsIds")
    HashSet<Requirement> findAllByIds(HashSet<Long> requirementsIds);
}
