/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import classes.*;
import dal.Conectadb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tinho
 */
public class CadastrarCursos extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

    public CadastrarCursos() {
        initComponents();
        this.setLocationRelativeTo(null);
        AlunosCadastrados();
    }

    public void AlunosCadastrados() {

        try {
            con = Conectadb.conectadb();
            String scriptSQL = "Select * FROM aluno";
            stmt = con.createStatement();
            rs = stmt.executeQuery(scriptSQL);

            int codigo;
            String nome = "";
            DefaultTableModel tabelaAlunos = (DefaultTableModel) alunosTable.getModel();
            while (rs.next()) {

                codigo = rs.getInt("codigo");
                nome = rs.getString("nome");

                Aluno aluno = new Aluno(codigo, nome);
                listaAlunos.add(aluno);

                tabelaAlunos.addRow(new String[]{nome});
            }

            rs.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ementaCursoLabel = new javax.swing.JLabel();
        editarCursoButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ementaCursoTextArea = new javax.swing.JTextArea();
        codigoCursoTextField = new javax.swing.JTextField();
        descricaoCursoTextField = new javax.swing.JTextField();
        codigoCursoLabel = new javax.swing.JLabel();
        descricaoCursoLabel = new javax.swing.JLabel();
        selecionaAlunoLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alunosTable = new javax.swing.JTable();
        salvaCursoButton = new javax.swing.JButton();
        testeLabel = new javax.swing.JLabel();
        selecionaAlunoLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ementaCursoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ementaCursoLabel.setText("Ementa:");

        editarCursoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editarCursoButton.setText("Editar Curso");
        editarCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCursoButtonActionPerformed(evt);
            }
        });

        ementaCursoTextArea.setColumns(20);
        ementaCursoTextArea.setRows(5);
        jScrollPane2.setViewportView(ementaCursoTextArea);

        codigoCursoTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        descricaoCursoTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        codigoCursoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codigoCursoLabel.setText("Código:");

        descricaoCursoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        descricaoCursoLabel.setText("Descrição:");

        selecionaAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selecionaAlunoLabel.setText("Selecione os alunos matrículados no curso");

        alunosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alunos"
            }
        ));
        jScrollPane3.setViewportView(alunosTable);

        salvaCursoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salvaCursoButton.setText("Salva novo Curso");
        salvaCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaCursoButtonActionPerformed(evt);
            }
        });

        testeLabel.setText("jLabel1");

        selecionaAlunoLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        selecionaAlunoLabel1.setText("Mantenha a tecla Ctrl pressionada e clique para marcar ou desmarcar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codigoCursoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(descricaoCursoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ementaCursoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(codigoCursoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                .addComponent(descricaoCursoTextField)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(salvaCursoButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                            .addComponent(editarCursoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(testeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selecionaAlunoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selecionaAlunoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selecionaAlunoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoCursoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoCursoLabel)
                    .addComponent(selecionaAlunoLabel1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descricaoCursoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descricaoCursoLabel))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ementaCursoLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salvaCursoButton)
                            .addComponent(editarCursoButton))
                        .addGap(27, 27, 27)
                        .addComponent(testeLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarCursoButtonActionPerformed
        new EditarCursos().setVisible(true);
    }//GEN-LAST:event_editarCursoButtonActionPerformed

    private void salvaCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaCursoButtonActionPerformed
        try {
            if(!codigoCursoTextField.getText().trim().equals("") && !descricaoCursoTextField.getText().trim().equals("")){
            DefaultTableModel alunoTableModel = (DefaultTableModel) alunosTable.getModel();
            int codigoCurso = Integer.parseInt(codigoCursoTextField.getText());
            con = Conectadb.conectadb();
            stmt = con.createStatement();

            String scriptSqlCurso = "Select * FROM curso";
            rs = stmt.executeQuery(scriptSqlCurso);
            boolean achou = false;
            while (rs.next()) {

                if (rs.getInt("codigo") == Integer.parseInt(codigoCursoTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "Código existente");
                    achou = true;
                }
            }
            if (achou == false) {
                String sql = "INSERT INTO curso (codigo,descricao,ementa) "
                        + "VALUES ("
                        + Integer.parseInt(codigoCursoTextField.getText()) + ", '"
                        + descricaoCursoTextField.getText() + "', '"
                        + ementaCursoTextArea.getText() + "')";
                stmt.executeUpdate(sql);

                int[] linhas = alunosTable.getSelectedRows();

                for (Aluno u : listaAlunos) {
                    for (int i = 0; i < linhas.length; i++) {

                        if (u.getNome().equals(alunoTableModel.getValueAt(linhas[i], 0))) {
                            String scriptSqlAlunos2 = "INSERT INTO curso_aluno ( codigo_aluno, codigo_curso) "
                                    + "VALUES (" + u.getCodigo() + ", " + codigoCurso + ")";
                            stmt.executeUpdate(scriptSqlAlunos2);
                        }
                    }
                }
                codigoCursoTextField.setText("");
                descricaoCursoTextField.setText("");
                ementaCursoTextArea.setText("");
                alunosTable.clearSelection();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            }
            con.close();
            }else{
                JOptionPane.showMessageDialog(null, "Preencha os campos codigo e descrição para salvar");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvaCursoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alunosTable;
    private javax.swing.JLabel codigoCursoLabel;
    private javax.swing.JTextField codigoCursoTextField;
    private javax.swing.JLabel descricaoCursoLabel;
    private javax.swing.JTextField descricaoCursoTextField;
    private javax.swing.JButton editarCursoButton;
    private javax.swing.JLabel ementaCursoLabel;
    private javax.swing.JTextArea ementaCursoTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton salvaCursoButton;
    private javax.swing.JLabel selecionaAlunoLabel;
    private javax.swing.JLabel selecionaAlunoLabel1;
    private javax.swing.JLabel testeLabel;
    // End of variables declaration//GEN-END:variables
}
