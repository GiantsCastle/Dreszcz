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
@Table(name = "character_table")
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "character_id", columnDefinition = "INTEGER(10) NOT NULL")
	private long characterId;
	@Column(name = "character_name", columnDefinition = "VARCHAR(10) NOT NULL")
	private String characterName;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "character_gold", columnDefinition = "INTEGER(3)")
	private int characterGold;
	@Column(name = "character_stamina", columnDefinition = "INTEGER(2)")
	private int characterStamina;
	@Column(name = "character_agility", columnDefinition = "INTEGER(2)")
	private int characterAgility;
	@Column(name = "character_luck", columnDefinition = "INTEGER(2)")
	private int characterLuck;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCharacterGold() {
		return characterGold;
	}
	public void setCharacterGold(int characterGold) {
		this.characterGold = characterGold;
	}
	public int getCharacterStamina() {
		return characterStamina;
	}
	public void setCharacterStamina(int characterStamina) {
		this.characterStamina = characterStamina;
	}
	public int getCharacterAgility() {
		return characterAgility;
	}
	public void setCharacterAgility(int characterAgility) {
		this.characterAgility = characterAgility;
	}
	public int getCharacterLuck() {
		return characterLuck;
	}
	public void setCharacterLuck(int characterLuck) {
		this.characterLuck = characterLuck;
	}
	
	


}
