package edu.mum.cs.cs425.demos.elibrary_springsec_1.model;

import javax.persistence.*;

@Entity
@Table(name="transcripts")
public class Transcript {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transcriptId;
	
	private String degreeTitle;

	public Transcript(String degreeTitle) {
		super();
		this.degreeTitle = degreeTitle;
	}

	public Transcript() {
		super();
	}

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	
	@Override
	public String toString() {
		return String.format("Transcript [transcriptId=%s, degreeTitle=%s]", transcriptId, degreeTitle);
	}
	

}
