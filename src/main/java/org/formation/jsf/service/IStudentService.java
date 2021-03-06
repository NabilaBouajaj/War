package org.formation.jsf.service;

import java.util.List;

import org.formation.jsf.model.Student;

public interface IStudentService {

	List<Student> getStudents() throws Exception;

	void addStudent(Student student) throws Exception;

	Student getStudent(Long id) throws Exception;

	void updateStudent(Student student) throws Exception;

	void deleteStudent(Long id) throws Exception;

}