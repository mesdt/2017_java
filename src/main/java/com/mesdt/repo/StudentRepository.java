package com.mesdt.repo;

import com.mesdt.core.Student;

import org.springframework.data.jpa.repository.JpaRepository;

/** Интерфейс репозитория для таблицы студентов. Класс репозитория будет сгенерирован автоматически */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
