package com.mesdt.repo;

import com.mesdt.core.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

/** Интерфейс репозитория для таблицы дисциплин. Класс репозитория будет сгенерирован автоматически */
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
