package company.team.vision.databaseJava.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import company.team.vision.databaseJava.dao.AdminSettingDao;
import company.team.vision.databaseJava.dao.XpertLineFunctionDao;
import company.team.vision.databaseJava.daoImpl.AdminSettingDaoJpaImpl;
import company.team.vision.databaseJava.daoImpl.XpertLineFunctionDaoImpl;
import company.team.vision.databaseJava.entity.AdminSetting;
import company.team.vision.databaseJava.entity.XpertLineFunction;
import company.team.vision.databaseJava.enums.PersistentType;
import company.team.vision.databaseJava.factory.PersistentFactory;

public class PersistentFactoryTest {
	
	@Test
	public void shouldReturnEntityManager() {
		EntityManager entityManager = PersistentFactory.getEntityManager(PersistentType.PERSISTENT_XPERTLINE_TEST);
		Assert.assertNotNull(entityManager);
				
		entityManager = PersistentFactory.getEntityManager(PersistentType.PERSISTENT_UNIT_TEST);
		Assert.assertNotNull(entityManager);
		
		entityManager = PersistentFactory.getEntityManager(PersistentType.PERSISTENT_INTEGRATION_TEST);
		Assert.assertNotNull(entityManager);
	}

	@Test
	public void shouldReturnDataUsing_Xline_Database() {
		XpertLineFunctionDao dao = new XpertLineFunctionDaoImpl();
		List<XpertLineFunction> result = dao.getFunctionsByLanguageOnDemo(PersistentFactory.getEntityManager(PersistentType.PERSISTENT_XPERTLINE_TEST), "EN");
		for (XpertLineFunction xline: result){
			System.out.println("============Description: "+xline.getDescription()+ "======Function code: "+xline.getFunctionCode());
		}
		Assert.assertEquals(11, result.size());
	}
	
	@Test
	public void shouldReturnDataUsingXrft_Integration_Test_Database() {
		AdminSettingDao dao = new AdminSettingDaoJpaImpl();
		List<AdminSetting> result = dao.getAllAdminSetting(PersistentFactory.getEntityManager(PersistentType.PERSISTENT_INTEGRATION_TEST));
		Assert.assertTrue(result.size() > 0);
	}
	
}
