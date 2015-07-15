package company.team.vision.databaseJava.dao;

import java.util.List;

import javax.persistence.EntityManager;

import company.team.vision.databaseJava.entity.XpertLineFunction;


public interface XpertLineFunctionDao {
	int getByLanguage(String languageCode);
	
	List<XpertLineFunction> getFunctionsByLanguage(String languageCode);
	List<XpertLineFunction> getFunctionsByLanguageOnDemo(EntityManager entityManager, String languageCode);
}
