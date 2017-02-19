package com.mesdt.core;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Класс JPA-сущности для таблицы студентов, внутри используются аннотации, которые описывают, как поля класса будут маппиться в реляционную БД */
@Entity
@Table(name = "students")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Это идентификатор записи, генерируется автоматически */
	@Id
	@GeneratedValue
	private Long id;

	/** Имя - непустая уникальная колонка */	
	@Column(nullable = false, unique = true)
	private String name;

	/** Коллекция оценок студента */
	@OneToMany(mappedBy = "id.student", cascade = CascadeType.REMOVE)
	private Collection<Score> scores;

	protected Student() {
		//
	}

	public Student(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("(student %d %s)", id, name);
	}

}
