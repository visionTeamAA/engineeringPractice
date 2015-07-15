package company.team.vision.databaseJava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "xrfl_adminSetting")
@NamedQueries({
	
@NamedQuery(name = "getAll", query="FROM AdminSetting")
})
public class AdminSetting extends BaseEntity {
	private static final long serialVersionUID = -5243455574197301724L;
	public static final String GET_ALL_METHOD = "getAll";
	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
