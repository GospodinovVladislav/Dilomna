package bg.proxiad.demo.championship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARTICIPANT")
public class Participant {
	
	@Id
    @GeneratedValue
	@Column(name="PARTICIPANT_ID")
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHOTO_FILE_NAME")
	private String photoFileName;
	
	@ManyToOne
	@JoinColumn(name="PARTICIPANT_GROUP_ID")
	private Group participantGroup;
	
	@Column(name="IS_IN_GROUP")
	private boolean isInGroup;
	
	@OneToOne(mappedBy = "participant")
	private Score score;

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public boolean getisInGroup() {
		return isInGroup;
	}

	public void setisInGroup(boolean isInGroup) {
		this.isInGroup = isInGroup;
	}

	public Group getParticipantGroup() {
		return participantGroup;
	}

	public void setParticipantGroup(Group participantGroup) {
		this.participantGroup = participantGroup;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

}
