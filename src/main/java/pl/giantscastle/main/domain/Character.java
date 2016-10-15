package pl.giantscastle.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "character_table")
public class Character {
	@Id
	@GeneratedValue
	@Column(name = "character_id", columnDefinition = "INTEGER(10) NOT NULL")
	private long characterId;
	@Column(name = "character_name", columnDefinition = "VARCHAR(10) NOT NULL")
	private String characterName;

	public long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(long characterId) {
		this.characterId = characterId;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

}
