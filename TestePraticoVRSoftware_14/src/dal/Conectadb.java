/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tinho
 */
public class Conectadb {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "root";

    public static Connection conectadb() throws ClassNotFoundException {
        String driver = "org.postgresql.Driver";
        String db = "jdbc:postgresql://localhost:5432/db_faculdade2";
        String user = "postgres";
        String password = "root";
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao encontrar o driver postgresql");
        }
        try {

            Connection con = DriverManager.getConnection(db, user, password);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            return con;
        } catch (SQLException error) {
            Connection conn = null;
            Statement stmt = null;
            try {
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                //STEP 4: Execute a query
                System.out.println("Creating database...");
                stmt = conn.createStatement();

                String sql = "CREATE DATABASE db_faculdade2";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try

            try {
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection
                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL + "db_faculdade2", USER, PASS);
                System.out.println("Connected database successfully...");

                //STEP 4: Execute a query
                System.out.println("Creating table in given database...");
                stmt = conn.createStatement();

                String sql = "CREATE TABLE Aluno "
                        + "(codigo INTEGER , "
                        + " nome VARCHAR(255),"
                        + " PRIMARY KEY ( codigo ))";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE CURSO ( codigo integer, descricao varchar (255), ementa varchar (255), primary key (codigo)) ";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE CURSO_ALUNO ( codigo bigserial, codigo_aluno integer, codigo_curso integer, primary key(codigo))";
                stmt.executeUpdate(sql);

                System.out.println("Created table in given database...");
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                }// do nothing
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try
            System.out.println("Goodbye!");
            
            try {
                Class.forName(JDBC_DRIVER);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Falha ao encontrar o driver postgresql");
            }

            Connection con;
            try {
                con = DriverManager.getConnection(DB_URL+"db_faculdade2", USER, PASS);
                return con;
            } catch (SQLException ex) {
                Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso");

        }
        return null;

    }
}
