package company.team.vision.databaseJava.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
 @SqlResultSetMapping(name="xpertLineFunction", entities=@EntityResult(entityClass=XpertLineFunction.class))
 @NamedNativeQuery(name="allXpertLineFunction", 
 query="SELECT HRMFUN.FUNKEY as id, HRMFUN.FUNDESC as [description], HRMFUND.HRi1A as translationLanguage, HRMFUND.FUNDESC as translation, HRMFUN.FUNCODE as functionCode "
 + "FROM HRMFUN LEFT JOIN HRMFUND ON HRMFUN.FUNKEY = HRMFUND.FUNKEY AND LOWER(HRMFUND.HRi1A) = LOWER(?)", 
 resultSetMapping="xpertLineFunction")
public class XpertLineFunction {
	@Id
	private Long id;

	@Column
	private String description;

	@Column
	private String translationLanguage;

	@Column
	private String translation;

	@Column
	private String functionCode;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTranslationLanguage() {
		return translationLanguage;
	}

	public void setTranslationLanguage(String translationLanguage) {
		this.translationLanguage = translationLanguage;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

}
