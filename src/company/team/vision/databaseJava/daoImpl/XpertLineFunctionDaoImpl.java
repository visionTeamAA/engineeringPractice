package company.team.vision.databaseJava.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.data.persistence.IIvyEntityManager;

import company.team.vision.databaseJava.JdbcConnectionFactory;
import company.team.vision.databaseJava.dao.XpertLineFunctionDao;
import company.team.vision.databaseJava.entity.XpertLineFunction;
import company.team.vision.databaseJava.utils.JPAUtils;


public class XpertLineFunctionDaoImpl implements XpertLineFunctionDao {
	private static final String XPERTLINE_CONNECTION_NAME = "XPLINE";

	@Override
	public int getByLanguage(String languageCode) {
		int n = 0;
		Connection connection = JdbcConnectionFactory.getConnection(XPERTLINE_CONNECTION_NAME);
		String queryString = "SELECT HRMFUN.FUNKEY as xpertLineId, HRMFUN.FUNDESC as [description], HRMFUND.HRi1A as langCode, HRMFUND.FUNDESC as translation, HRMFUN.FUNCODE as functionCode "
				+ "FROM HRMFUN LEFT JOIN HRMFUND ON HRMFUN.FUNKEY = HRMFUND.FUNKEY AND LOWER(HRMFUND.HRi1A) = LOWER(?)";
		if (connection != null) {
			try {
				PreparedStatement stm = connection.prepareStatement(queryString);
				try {
					stm.setString(1, languageCode);
					ResultSet result = stm.executeQuery();
					try {
						while (result.next()) {
							n++;
						}
					} finally {
						try {
							result.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				} finally {
					try {
						stm.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return n;
	}

	@Override
	public List<XpertLineFunction> getFunctionsByLanguage(String languageCode) {
		IIvyEntityManager ivyEntityManager = Ivy.persistence().get("xpertLine");
		
		
		EntityManager entityManager = ivyEntityManager.createEntityManager();
		TypedQuery<XpertLineFunction> functionsQuery = entityManager.createNamedQuery("allXpertLineFunction", XpertLineFunction.class);
		functionsQuery.setParameter(1, languageCode);
		return functionsQuery.getResultList();
	}

	
	@Override
	public List<XpertLineFunction> getFunctionsByLanguageOnDemo(EntityManager entityManager, String languageCode) {
		TypedQuery<XpertLineFunction> functionsQuery = entityManager.createNamedQuery("allXpertLineFunction", XpertLineFunction.class);
		functionsQuery.setParameter(1, languageCode);
		return functionsQuery.getResultList();
	}
}
