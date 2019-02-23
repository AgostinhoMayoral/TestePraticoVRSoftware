/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import classes.Aluno;
import classes.Curso;
import classes.Curso_Aluno;
import dal.Conectadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tinho
 */
public class MainPage extends javax.swing.JFrame {

    Conectadb conectaDBObj = new Conectadb();
    ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
    ArrayList<Curso> listaCurso = new ArrayList<Curso>();
    ArrayList<Curso_Aluno> listaCurso_alunos = new ArrayList<Curso_Aluno>();

    public MainPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        MatriculasCadastrados();
    }

    public void MatriculasCadastrados() {

      
            

        try {
            listaAluno = conectaDBObj.selectListaAlunosDB();
            listaCurso = conectaDBObj.selectListaCursosDB();
            listaCurso_alunos = conectaDBObj.selectListaCurso_AlunoDB();
            DefaultTableModel tabelaMatricula = (DefaultTableModel) matriculasTable.getModel();
            tabelaMatricula.setRowCount(0);
            for (Curso_Aluno u : listaCurso_alunos) {
                Object[] lista = {u.getCodigo(), u.getCodigo_aluno(), u.getCodigo_curso()};
                tabelaMatricula.addRow(lista);
            }
            for (int i =0; i < matriculasTable.getRowCount();i++ ) {
                for (Aluno u : listaAluno) {
                    if(matriculasTable.getValueAt(i, 1).equals(u.codigo)){
                        matriculasTable.setValueAt(u.nome, i, 1);
                    }
                }
            }
            for (int i =0; i < matriculasTable.getRowCount();i++ ) {
                for (Curso u : listaCurso) {
                    if(matriculasTable.getValueAt(i, 2).equals(u.getCodigo())){
                        matriculasTable.setValueAt(u.getDescricao(), i, 2);
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
            


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        matriculaAlunojButton = new javax.swing.JButton();
        matriculaCursojButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        matriculasTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        matriculaAlunojButton.setText("Cadastro de Aluno");
        matriculaAlunojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaAlunojButtonActionPerformed(evt);
            }
        });

        matriculaCursojButton.setText("Cadastro de Curso");
        matriculaCursojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaCursojButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Matrículas Realizadas");

        matriculasTable.setAutoCreateRowSorter(true);
        matriculasTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matriculasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código_Aluno", "Código_Curso"
            }
        ));
        jScrollPane1.setViewportView(matriculasTable);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matriculaCursojButton)
                            .addComponent(matriculaAlunojButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(refreshButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(matriculaAlunojButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(matriculaCursojButton)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matriculaAlunojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaAlunojButtonActionPerformed

            new EditarAlunos().setVisible(true);
        
    }//GEN-LAST:event_matriculaAlunojButtonActionPerformed

    private void matriculaCursojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaCursojButtonActionPerformed
        new EditarCursos().setVisible(true);
    }//GEN-LAST:event_matriculaCursojButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        MatriculasCadastrados();
    }//GEN-LAST:event_refreshButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton matriculaAlunojButton;
    private javax.swing.JButton matriculaCursojButton;
    private javax.swing.JTable matriculasTable;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
