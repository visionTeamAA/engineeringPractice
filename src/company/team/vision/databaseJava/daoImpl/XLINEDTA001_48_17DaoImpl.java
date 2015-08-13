package company.team.vision.databaseJava.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import company.team.vision.databaseJava.dao.XLINEDTA001_48_17Dao;


public class XLINEDTA001_48_17DaoImpl implements  XLINEDTA001_48_17Dao{

	@Override
	public List<Object[]> getDataFromView(EntityManager entityManager) {
		Query query = entityManager.createNativeQuery("select * from placeholders");
		List<Object[]> list = (List<Object[]>)query.getResultList();
		System.out.println("--------------size: "+list.size());
		for (Object[] obj: list){			
			System.out.println("--------------empkey : "+obj[0]);
			System.out.print("--------------connumb : "+obj[1]);
			System.out.print("--------------employeeNumber : "+obj[2]);
			System.out.print("--------------firstName : "+obj[3]);
			System.out.print("--------------lastName : "+obj[4]);
			System.out.print("--------------fullName : "+obj[5]);
			System.out.print("--------------empSign : "+obj[6]);
			System.out.print("--------------empSaluation : "+obj[7]);
			System.out.print("--------------empTitle : "+obj[8]);
		}		
		return list;
	}

	
}

