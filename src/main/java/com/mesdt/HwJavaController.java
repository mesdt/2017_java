package com.mesdt;

import com.mesdt.core.Student;
import com.mesdt.svc.HwJavaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HwJavaController {

	@Autowired
	private HwJavaService hwJavaService;

	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(Model vars) {
		vars.addAttribute("students", hwJavaService.students());
		return "students";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/students/{id}")
	public String student(@PathVariable Long id, Model vars) {
		Student student = hwJavaService.student(id);
		vars.addAttribute("student", student).addAttribute("scores", hwJavaService.scores(student));
		return "student";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public String createStudent(@RequestParam String name) {
		Student student = hwJavaService.createStudent(name);
		return "redirect:/students/" + student.getId();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		hwJavaService.deleteStudent(id);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}/scores")
	public String setScores(@PathVariable Long id, @RequestParam("subjectIds[]") Long[] subjectIds,
			@RequestParam("scores[]") Integer[] scores) {
		Student student = hwJavaService.student(id);
		hwJavaService.setScores(student, subjectIds, scores);
		return "redirect:/students/" + student.getId();
	}

}
