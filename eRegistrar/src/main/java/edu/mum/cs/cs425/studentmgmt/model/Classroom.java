package edu.mum.cs.cs425.studentmgmt.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="classrooms")
public class Classroom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long classroomId;
	
	@Column(name="building_name")
	private String buildingName;
	@Column(name="room_number")
	private String roomNumber;
	
	@OneToMany(mappedBy="classroom")
	private List<Student> students;
	
	
	
     
	public Classroom() {
		super();
	}

	public Classroom(String buildingName, String roomNumber) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	
	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return String.format("Classroom [classroomId=%s, buildingName=%s, roomNumber=%s, students=%s]", classroomId,
				buildingName, roomNumber, students);
	}
	
	
	
	

  
}
