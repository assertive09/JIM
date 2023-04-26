package com.jim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jim.model.Student;

public interface StudentRepo extends CrudRepository <Student, Integer> {
    
    @Query("select s from Student s where s.email = :e and s.password= :p")
    public Student getStudentByNameandPassword(@Param ("e") String email, @Param ("p") String password);

    @Query("select s from Student s")
    public List<Student> getAllStudent();
}
