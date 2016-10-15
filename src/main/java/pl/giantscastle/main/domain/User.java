package pl.giantscastle.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id", columnDefinition = "INTEGER(10) NOT NULL")
	private long userId;
//	@OneToOne
//	@JoinColumn(name = "character_id")
	@Column(name = "character_id")
	private long characterId;
	@Column(name = "user_name", columnDefinition = "VARCHAR(10) NOT NULL")
	private String userName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(long l) {
		this.characterId = l;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
