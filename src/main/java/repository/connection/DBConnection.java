package repository.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private final static String url = "jdbc:postgresql://localhost:5433";
    private final static String user = "postgres";
    private final static String password = "postgres";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() throws IOException {
        Connection conn = null;
        try {
            DataSource dataSource = (DataSource) new InitialContext().lookup("JDBC/postgres");
            conn = dataSource.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public DBConnection(){

    }
}

