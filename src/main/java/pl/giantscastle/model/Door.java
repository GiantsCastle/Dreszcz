package pl.giantscastle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "door_table")
public class Door {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "door_id", columnDefinition = "INTEGER(10) NOT NULL")
	private long doorId;
	@OneToOne
	@JoinColumn(name = "character_id")
	private Character character;
	@Column(name = "door_open_001", columnDefinition = "BIT")
	private boolean doorOpen001;
	@Column(name = "door_open_002", columnDefinition = "BIT")
	private boolean doorOpen002;
	public long getDoorId() {
		return doorId;
	}
	public void setDoorId(long doorId) {
		this.doorId = doorId;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public boolean isDoorOpen001() {
		return doorOpen001;
	}
	public void setDoorOpen001(boolean doorOpen001) {
		this.doorOpen001 = doorOpen001;
	}
	public boolean isDoorOpen002() {
		return doorOpen002;
	}
	public void setDoorOpen002(boolean doorOpen002) {
		this.doorOpen002 = doorOpen002;
	}
	
	
}
