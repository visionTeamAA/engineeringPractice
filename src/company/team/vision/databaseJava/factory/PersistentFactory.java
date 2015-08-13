package company.team.vision.databaseJava.factory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import company.team.vision.databaseJava.enums.PersistentType;

public abstract class PersistentFactory {

	public static EntityManager getEntityManager(PersistentType persistentType) {
		EntityManager entityManager = null;
		switch (persistentType) {
			case PERSISTENT_UNIT_TEST:
				entityManager = createEntityManager(PersistentType.PERSISTENT_UNIT_TEST
						.getPersistentName());
				break;
			case PERSISTENT_INTEGRATION_TEST:
				entityManager = createEntityManager(PersistentType.PERSISTENT_INTEGRATION_TEST
						.getPersistentName());
				break;
			case PERSISTENT_XPERTLINE_TEST:
				entityManager = createEntityManager(PersistentType.PERSISTENT_XPERTLINE_TEST
						.getPersistentName());
				break;
			
			case XLINEDTA001_48_17:
				entityManager = createEntityManager(PersistentType.XLINEDTA001_48_17
						.getPersistentName());
				break;
			}
		return entityManager;
	}

	private static EntityManager createEntityManager(String persistenceUnitName) {
		return Persistence.createEntityManagerFactory(persistenceUnitName)
				.createEntityManager();
	}
}
