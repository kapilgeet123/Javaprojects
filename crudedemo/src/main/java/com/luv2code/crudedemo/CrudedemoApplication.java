package com.luv2code.crudedemo;

import com.luv2code.crudedemo.dao.StudentDAO;
import com.luv2code.crudedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudedemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAOs)
	{
		return runner -> {
//			createStudent(studentDAOs);
//			readStudent(studentDAOs);
//			queryForStudents(studentDAOs);
//			queryForStudentsByLastName(studentDAOs);
//			updateStudent(studentDAOs);
//			deleteStudent(studentDAOs);
//			deleteAllStudent(studentDAOs);
			createMultipleStudents(studentDAOs);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAOs) {
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAOs.save(tempStudent1);
		studentDAOs.save(tempStudent2);
		studentDAOs.save(tempStudent3);
	}

	private void deleteAllStudent(StudentDAO studentDAOs) {
		int numRowsDeleted = studentDAOs.deleteAll();
		System.out.println("number of rows deleted"+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAOs) {
		int studentId =3;
		studentDAOs.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAOs) {
		int studentId =1;
		Student myStudent = studentDAOs.findById(studentId);
		myStudent.setFirstName("Scooby");
		studentDAOs.update(myStudent);
		System.out.println("updated student"+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAOs) {
		List<Student> theStudents = studentDAOs.findbyLastName("Doe");
		for(Student tempStudent:theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAOs) {
		List<Student> theStudents = studentDAOs.findAll();
		for(Student tempStudent: theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAOs) {
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
		studentDAOs.save(tempStudent);
		int theId = tempStudent.getId();
		Student myStudent = studentDAOs.findById(theId);
		System.out.println("Found the student "+myStudent);
	}

	public void createStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");
		studentDAO.save(tempStudent);
		System.out.println("Saved student generated Id"+tempStudent.getId());
	}

}
