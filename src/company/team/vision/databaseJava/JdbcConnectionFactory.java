package company.team.vision.databaseJava;

import java.sql.Connection; 
import java.sql.SQLException;
import java.util.concurrent.Callable;

import ch.ivyteam.ivy.db.IExternalDatabase;
import ch.ivyteam.ivy.db.IExternalDatabaseApplicationContext;
import ch.ivyteam.ivy.environment.EnvironmentNotAvailableException;
import ch.ivyteam.ivy.environment.Ivy;

public final class JdbcConnectionFactory {
	private JdbcConnectionFactory() {}
	
	public static Connection getConnection(String ivyDbConnectionName) {
		try {
			return getDatabase(ivyDbConnectionName).getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * private use for getting the IExternalDatabase object corresponding to the ivyDbConnectionName.
	 * @param ivyDbConnectionName
	 * @return
	 * @throws Exception
	 */
	private static IExternalDatabase getDatabase(final String ivyDbConnectionName) {
		IExternalDatabase database = null;
		try {
			database = Ivy.session().getSecurityContext().executeAsSystemUser(new Callable<IExternalDatabase>() {
						public IExternalDatabase call() throws Exception {
							IExternalDatabaseApplicationContext context = 
									(IExternalDatabaseApplicationContext) Ivy.wf().getApplication().
									getAdapter(IExternalDatabaseApplicationContext.class);
							return context.getExternalDatabase(ivyDbConnectionName);
						}
					});
		} catch (EnvironmentNotAvailableException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return database;
	}
}
