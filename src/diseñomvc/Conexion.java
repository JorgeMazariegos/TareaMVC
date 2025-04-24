/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diseñomvc;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.nio.file.Paths;

/**
 *
 * @author i5
 */
public class Conexion {
    static Properties config = new Properties();
    String hostname = null;
    String port = null;
    String database = null;
    String username = null;
    String password = null;

    public Conexion(){
        InputStream in;
        String path = "C:\\Users\\i5\\Documents\\NetBeansProjects\\DiseñoMVC\\src\\diseñomvc\\DBConfig.properties";
        
        try{
            in = Files.newInputStream(Paths.get(path));
            config.load(in);
            in.close();
            loadProperties();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void loadProperties(){
        this.hostname = config.getProperty("hostname");
        this.port = config.getProperty("port");
        this.database = config.getProperty("database");
        this.username = config.getProperty("username");
        this.password = config.getProperty("password");
    }
    
    public Connection getConnection() throws SQLException{
        Connection conn;
        String jdbcUrl = "jdbc:postgresql://"+this.hostname+":"+this.port+"/"+this.database;
        conn = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Conexion establecida");
        return conn;
    }
}
