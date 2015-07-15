package company.team.vision.databaseJava.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import company.team.vision.databaseJava.dao.AdminSettingDao;
import company.team.vision.databaseJava.entity.AdminSetting;

public class AdminSettingDaoJpaImpl implements AdminSettingDao {
	public AdminSettingDaoJpaImpl(){
		super();
	}

	@Override
	public List<AdminSetting> getAllAdminSetting(EntityManager entityManager) {
		TypedQuery<AdminSetting> query = entityManager.createNamedQuery(AdminSetting.GET_ALL_METHOD,AdminSetting.class);
		return query.getResultList();		
	}
}
