package com.mesdt.repo;

import java.util.List;

import com.mesdt.core.Score;
import com.mesdt.core.Student;

import org.springframework.data.jpa.repository.JpaRepository;

/** Интерфейс репозитория для таблицы оценок. Класс репозитория будет сгенерирован автоматически */
public interface ScoreRepository extends JpaRepository<Score, Score.Id> {

	List<Score> findByIdStudent(Student student);

	Long deleteByIdStudent(Student student);

}
