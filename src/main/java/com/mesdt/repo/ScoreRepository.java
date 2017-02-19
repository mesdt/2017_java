package com.mesdt.repo;

import java.util.List;

import com.mesdt.core.Score;
import com.mesdt.core.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Score.Id> {

	List<Score> findByIdStudent(Student student);

	Long deleteByIdStudent(Student student);

}
