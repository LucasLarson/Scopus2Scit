import java.sql.Connection;

public class ConnectionFactory {

	public Connection conn = null;	
	private final String url = "jdbc:sqlserver://";
	private final String serverName = "iingen-dev01";
	private final String port = "1433";
	private final String databaseName = "SCIT-Catalogos";
	private final String userName = "SCIT_Importador";
	private final String password = "5c1t-1m9ort4dor*";
	private final String selectMethod = "Direct";
	
	public String getConnectionUrl() {
		return url + serverName + ":" + port + ";databaseName=" + databaseName
				+ ";selectMethod=" + selectMethod + ";";
	}

	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = java.sql.DriverManager.getConnection(getConnectionUrl(),
					userName, password);
			/*if (conn != null)
				System.out.println("Connection Successful!");*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : "
					+ e.getMessage());
		}
		return conn;
	}

	public void displayDbProperties() {
		java.sql.DatabaseMetaData dm = null;
		java.sql.ResultSet result = null;
		try {
			conn = this.getConnection();
			if (conn != null) {
				dm = conn.getMetaData();
				System.out.println("Driver Information");
				System.out.println("\tDriver Name: " + dm.getDriverName());
				System.out
						.println("\tDriver Version: " + dm.getDriverVersion());
				System.out.println("\nDatabase Information ");
				System.out.println("\tDatabase Name: "
						+ dm.getDatabaseProductName());
				System.out.println("\tDatabase Version: "
						+ dm.getDatabaseProductVersion());

				/*
				 * Statement select = conn.createStatement(); result =
				 * select.executeQuery(statement);
				 * 
				 * while (result.next()) { System.out.println("Nombre: " +
				 * result.getString(1) + "\n"); System.out.println("Apellido: "
				 * + result.getString(2) + "\n"); System.out.println("Dni: " +
				 * result.getString(3) + "\n"); } result.close(); result = null;
				 */
				
				closeConnection();
			} else
				System.out.println("Error: No active Connection");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm = null;
	}

	public void closeConnection() {
		try {
			if (conn != null)
				conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
