package pl.giantscastle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "variable_table")
public class Variable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "variable_id", columnDefinition = "INTEGER(10) NOT NULL")
	private long variableId;

}
