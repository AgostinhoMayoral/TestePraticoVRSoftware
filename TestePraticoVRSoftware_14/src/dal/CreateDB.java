/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.*;

public class CreateDB {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main() {
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

            String sql = "CREATE DATABASE IF NOT EXISTS db_faculdade2;";
            stmt.executeUpdate(sql);

         /*   String sqlCreateTableAluno = "create table aluno(codigo integer primary key,nome varchar(50));";
            stmt.executeUpdate(sqlCreateTableAluno);

            String sqlCreateTableCurso = "CREATE TABLE CURSO(codigo integer primary key, descricao varchar (255), ementa text);";
            stmt.executeUpdate(sqlCreateTableCurso);

            String sqlCreateTableCurso_Aluno = "create table curso_aluno("
                    + ""
                    + "	codigo bigserial primary key,"
                    + "	codigo_aluno integer,"
                    + "	codigo_curso integer,"
                    + "	foreign key (codigo_aluno) references aluno(codigo),"
                    + "	foreign key (codigo_curso) references curso(codigo)"
                    + ");";
*/
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
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample
