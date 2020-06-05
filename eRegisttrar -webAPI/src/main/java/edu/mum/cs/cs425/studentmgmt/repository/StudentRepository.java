package edu.mum.cs.cs425.studentmgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.mum.cs.cs425.studentmgmt.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
