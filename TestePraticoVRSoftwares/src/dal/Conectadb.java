/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import classes.Aluno;
import classes.Curso;
import classes.Curso_Aluno;
import java.sql.*;
import java.util.ArrayList;
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
    static final String DB = "db_faculdade2";
    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "root";
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public static Connection conectadb() throws ClassNotFoundException {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao encontrar o driver postgresql");
        }
        try {

            Connection con = DriverManager.getConnection(DB_URL + DB, USER, PASS);
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
                conn = DriverManager.getConnection(DB_URL + DB, USER, PASS);
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
            System.out.println("Restarting connection");

            try {
                Class.forName(JDBC_DRIVER);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Falha ao encontrar o driver postgresql");
            }

            try {
                Connection con = DriverManager.getConnection(DB_URL + DB, USER, PASS);
                System.out.println("Connection started");

                return con;
            } catch (SQLException ex) {
                Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso");

        }
        return null;

    }

    public ArrayList<Curso> selectListaCursosDB() {
        try {
            ArrayList<Curso> listaCurso = new ArrayList<Curso>();
            String scriptSqlCurso = "Select * FROM curso";
            try {
                con = Conectadb.conectadb();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(scriptSqlCurso);

            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("codigo"), rs.getString("descricao"), rs.getString("ementa"));
                listaCurso.add(curso);
            }

            rs.close();
            stmt.close();
            con.close();

            return listaCurso;
        } catch (SQLException ex) {
            Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Aluno> selectListaAlunosDB() throws ClassNotFoundException {
        try {
            ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();

            String scriptSqlAlunos = "Select * FROM aluno";
            con = Conectadb.conectadb();
            stmt = con.createStatement();
            rs = stmt.executeQuery(scriptSqlAlunos);

            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("codigo"), rs.getString("nome"));
                listaAluno.add(aluno);
            }

            rs.close();
            stmt.close();
            con.close();

            return listaAluno;
        } catch (SQLException ex) {
            Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Curso_Aluno> selectListaCurso_AlunoDB() throws ClassNotFoundException {
        try {
            ArrayList<Curso_Aluno> listaCurso_Aluno = new ArrayList<Curso_Aluno>();
            String scriptSqlCurso_Aluno = "Select * FROM curso_aluno";
            con = Conectadb.conectadb();
            stmt = con.createStatement();
            rs = stmt.executeQuery(scriptSqlCurso_Aluno);

            while (rs.next()) {
                Curso_Aluno curso_aluno = new Curso_Aluno(rs.getInt("codigo"), rs.getInt("codigo_aluno"), rs.getInt("codigo_curso"));
                listaCurso_Aluno.add(curso_aluno);
            }

            rs.close();
            stmt.close();
            con.close();

            return listaCurso_Aluno;
        } catch (SQLException ex) {
            Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
