package com.assign.develop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assign.develop.model.Skills;

@Repository
public interface SkillsRepo  extends JpaRepository<Skills, Long>{

}
