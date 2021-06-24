package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    public ConexaoBD() {
        super();
    }

    //Parâmetros de conexão
    private final String dbname = "dbhotelaria";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/" + dbname + "?useTimezone=true&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "Dba@123";

    //Conexão
    protected Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
