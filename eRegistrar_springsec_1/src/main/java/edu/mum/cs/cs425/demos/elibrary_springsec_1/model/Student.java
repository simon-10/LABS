package edu.mum.cs.cs425.demos.elibrary_springsec_1.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"student_number"})})
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long studentId;
	
	
	@NotBlank(message="Student number required")
	@Column(name="student_number", unique=true, nullable=false)
	private String studentNumber;
	
	
	@NotBlank(message="First name required")
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="middle_name", nullable=true)
	private String middleName;
	
	
	@NotBlank(message="Last name required")
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="CGPA", nullable=true)
    private Double cgpa;
	
	
	@Column(name="enrollmet_date", nullable=true)
	private LocalDate dateOfEnrollment;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="transcriptt")
	private Transcript transcript;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="class_room")
	private Classroom classroom;
	
	public Student() {
		super();
	}

	

	public Student(@NotBlank(message = "Student number required") String studentNumber,
                   @NotBlank(message = "First name required") String firstName, String middleName,
                   @NotBlank(message = "Last name required") String lastName, Double cgpa, LocalDate dateOfEnrollment,
                   Transcript transcript) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		
	}



	public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa,
                   LocalDate dateOfEnrollment, Transcript transcript) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript=transcript;
	}


	

	public Classroom getClassroom() {
		return classroom;
	}



	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}



	public Transcript getTranscript() {
		return transcript;
	}



	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}



	public Long getStudentId() {
		return studentId;
	}

	
	
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}



	@Override
	public String toString() {
		return String.format(
				"Student [studentId=%s, studentNumber=%s, firstName=%s, middleName=%s, lastName=%s, cgpa=%s, dateOfEnrollment=%s, transcript=%s, classroom=%s]",
				studentId, studentNumber, firstName, middleName, lastName, cgpa, dateOfEnrollment, transcript,
				classroom);
	}

}
