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
@Table(name = "variable_table")
public class Variable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "variable_id", columnDefinition = "INTEGER(10) NOT NULL")
	private long variableId;
	@OneToOne
	@JoinColumn(name = "character_id")
	private Character character;
	@Column(name = "lake_swim", columnDefinition = "INTEGER(3)")
	private int lakeSwim;
	public long getVariableId() {
		return variableId;
	}
	public void setVariableId(long variableId) {
		this.variableId = variableId;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public int getLakeSwim() {
		return lakeSwim;
	}
	public void setLakeSwim(int lakeSwim) {
		this.lakeSwim = lakeSwim;
	}
	
	

}
