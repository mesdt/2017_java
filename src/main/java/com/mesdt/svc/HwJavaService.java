package com.mesdt.svc;

import java.util.Collection;
import java.util.Map;

import com.mesdt.core.Student;
import com.mesdt.core.Subject;

public interface HwJavaService {

	Collection<Student> students();

	Student student(Long id);

	Map<Subject, Integer> scores(Student student);

	void setScores(Student student, Long[] subjectIds, Integer[] scores);

	Student createStudent(String name);

	void deleteStudent(Long id);

}
