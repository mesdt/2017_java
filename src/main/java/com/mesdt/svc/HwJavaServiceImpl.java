package com.mesdt.svc;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import com.mesdt.core.Score;
import com.mesdt.core.Student;
import com.mesdt.core.Subject;
import com.mesdt.repo.ScoreRepository;
import com.mesdt.repo.StudentRepository;
import com.mesdt.repo.SubjectRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HwJavaServiceImpl implements HwJavaService {

	@Autowired
	private StudentRepository studentz;

	@Autowired
	private SubjectRepository subjectz;

	@Autowired
	private ScoreRepository scorez;

	protected final Log log = LogFactory.getLog(getClass());

	@Override
	public Collection<Student> students() {
		return studentz.findAll();
	}

	@Override
	public Student student(Long id) {
		return studentz.getOne(id);
	}

	@Override
	public Map<Subject, Integer> scores(Student student) {
		// XXX: ручной джоин!
		Map<Subject, Integer> scores = new HashMap<>();
		for (Subject subject : subjectz.findAll()) {
			scores.put(subject, null);
		}
		for (Score score : scorez.findByIdStudent(student)) {
			scores.put(score.getSubject(), score.getScore());
		}
		return scores;
	}

	@Override
	@Transactional
	public void setScores(Student student, Long[] subjectIds, Integer[] scores) {
		scorez.deleteByIdStudent(student);
		int i = 0;
		for (Subject subject : subjectz.findAll(Arrays.asList(subjectIds))) {
			if (scores[i] != null) {
				scorez.save(new Score(student, subject, scores[i]));
			}
			++i;
		}
	}

	@Override
	public Student createStudent(String name) {
		return studentz.save(new Student(name));
	}

	@Override
	public void deleteStudent(Long id) {
		studentz.delete(id);
	}

}
