package projeto.repositorio;

import org.eclipse.jetty.io.RuntimeIOException;
import java.sql.*;


public abstract class Repositorio {
    private static String host =System.getenv("TESTEPHP_POSTGRES_HOST");
    private static final String URL = "jdbc:postgresql://"+ host+ ":5432/postgres"; //
    private static final String USERNAME = "";
    private static final String PASSWORD = System.getenv("TESTEPHP_POSTGRES_PASSWORD");;
    private static Connection con;
    
    protected Connection getConnection() {
        try {
            
            if(con == null || con.isClosed()){
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }
            return con;
            

        } catch (Exception e) {
            throw new RuntimeIOException(e);
        }
    }
}
