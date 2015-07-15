package company.team.vision.databaseJava.dao;

import java.util.List;

import javax.persistence.EntityManager;

import company.team.vision.databaseJava.entity.AdminSetting;


public interface AdminSettingDao  {
	List<AdminSetting> getAllAdminSetting(EntityManager entityManager);
}
