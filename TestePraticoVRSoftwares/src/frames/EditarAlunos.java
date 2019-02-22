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
public class EditarAlunos extends javax.swing.JFrame {

    Conectadb conectaDBObj = new Conectadb();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Aluno> listaAluno =  new ArrayList<Aluno>();
    ArrayList<Curso> listaCurso =  new ArrayList<Curso>();
    ArrayList<Curso_Aluno> listaCurso_Aluno =  new ArrayList<Curso_Aluno>();

    ArrayList<Curso_Aluno> cursoAdicionadoOURemoveux = new ArrayList<Curso_Aluno>();

    int linhaSelecionada = -1;
    int codigoAluno = -1;

    public EditarAlunos() {
        initComponents();
        this.setLocationRelativeTo(null);
        listaCurso = conectaDBObj.selectListaCursosDB();
        for (Curso u : listaCurso) {
                    cursosComboBox.addItem(u.descricao);
                }
        CarregaTabelas();

    }

    public void CarregaTabelas() {

        try {

            DefaultTableModel tabelaAlunos = (DefaultTableModel) alunosTable.getModel();
            tabelaAlunos.setRowCount(0);
            //tabelaCurso.setRowCount(0);
            //cursosComboBox.removeAllItems();
            
            //listaCurso_Aluno = null;
            listaAluno = conectaDBObj.selectListaAlunosDB();

            listaCurso_Aluno = conectaDBObj.selectListaCurso_AlunoDB();
            
            

                for (Aluno u : listaAluno) {
                    tabelaAlunos.addRow(new Object[]{u.codigo, u.nome});
                }
                



        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cadastroAlunoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alunosTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        codigoAlunoLabel = new javax.swing.JLabel();
        nomeAlunoLabel = new javax.swing.JLabel();
        codigoAlunoTextField = new javax.swing.JTextField();
        nomeAlunoTextField = new javax.swing.JTextField();
        cursosComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        cursosTable = new javax.swing.JTable();
        atualizarAlunoButton = new javax.swing.JButton();
        deletaCursoButton = new javax.swing.JButton();
        insiraAlunoLabel = new javax.swing.JLabel();
        excluirAlunoButton = new javax.swing.JButton();
        adicionaCursoButton1 = new javax.swing.JButton();
        testeLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cadastroAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cadastroAlunoLabel.setText("Alunos Cadastrados:");

        alunosTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        alunosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ));
        alunosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                alunosTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(alunosTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cadastroAlunoLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cadastroAlunoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        codigoAlunoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codigoAlunoLabel.setText("Código:");

        nomeAlunoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nomeAlunoLabel.setText("Nome:");

        codigoAlunoTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codigoAlunoTextField.setEnabled(false);

        nomeAlunoTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        cursosComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cursosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso"
            }
        ));
        jScrollPane2.setViewportView(cursosTable);

        atualizarAlunoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        atualizarAlunoButton.setText("Atualizar Aluno");
        atualizarAlunoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarAlunoButtonActionPerformed(evt);
            }
        });

        deletaCursoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deletaCursoButton.setText("-");
        deletaCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaCursoButtonActionPerformed(evt);
            }
        });

        insiraAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insiraAlunoLabel.setText("Insira cursos ao Aluno");

        excluirAlunoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        excluirAlunoButton.setText("Excluir Aluno");
        excluirAlunoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirAlunoButtonActionPerformed(evt);
            }
        });

        adicionaCursoButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adicionaCursoButton1.setText("+");
        adicionaCursoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaCursoButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoAlunoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeAlunoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeAlunoTextField)
                            .addComponent(codigoAlunoTextField))
                        .addGap(277, 277, 277))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(atualizarAlunoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(excluirAlunoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cursosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insiraAlunoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionaCursoButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletaCursoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoAlunoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoAlunoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeAlunoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAlunoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insiraAlunoLabel)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cursosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionaCursoButton1)
                    .addComponent(deletaCursoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atualizarAlunoButton)
                    .addComponent(excluirAlunoButton))
                .addContainerGap())
        );

        testeLabel.setText("jLabel1");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(testeLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jButton1)))
                        .addContainerGap(218, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(testeLabel)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarAlunoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarAlunoButtonActionPerformed
        try {
            con = Conectadb.conectadb();
            stmt = con.createStatement();
            String scriptUpdateNomeAluno = "UPDATE Aluno SET nome = '" + nomeAlunoTextField.getText() + "'"
                    + "WHERE codigo in (" + codigoAluno + ")";
            stmt.executeUpdate(scriptUpdateNomeAluno);

            for (Curso_Aluno u : cursoAdicionadoOURemoveux) {
                if (u.codigo == 1) {
                    String scriptSqlAluno = "INSERT INTO curso_aluno (codigo_aluno,codigo_curso) "
                            + "VALUES (" + u.codigo_aluno + ", " + u.codigo_curso + ");";
                    stmt.executeUpdate(scriptSqlAluno);
                }
                if (u.codigo == 2) {
                    String scriptSqlAlunos2 = "DELETE FROM curso_aluno "
                            + "WHERE codigo_aluno = " + u.codigo_aluno + " AND codigo_curso = " + u.codigo_curso + ";";
                    stmt.executeUpdate(scriptSqlAlunos2);

                }
            }
            CarregaTabelas();
            linhaSelecionada = -1;
            codigoAluno = -1;
            codigoAlunoTextField.setText("");
            nomeAlunoTextField.setText("");
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_atualizarAlunoButtonActionPerformed

    private void adicionaCursoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaCursoButton1ActionPerformed

        DefaultTableModel cursosTabela = (DefaultTableModel) cursosTable.getModel();
        String cursoSelecionado = (String) cursosComboBox.getSelectedItem();

        if (cursosComboBox.getItemCount() > 0) {
            boolean achou = false;
            
            for (int i = 0; i < cursosTabela.getRowCount(); i++) {
                if (cursosTabela.getValueAt(i, 0).equals(cursoSelecionado)) {
                    achou = true;

                }
            }
            if (achou == false) {
                for (Curso u : listaCurso) {
                    if (u.getDescricao().equals((String) cursosComboBox.getSelectedItem())) {
                        //1 = adicionou
                        Curso_Aluno curso_aluno = new Curso_Aluno(1, codigoAluno, u.codigo);
                        cursoAdicionadoOURemoveux.add(curso_aluno);
                        Object[] cursoObj = {cursosComboBox.getSelectedItem()};
                        cursosTabela.addRow(cursoObj);
                    }
                }

            }

        }

    }//GEN-LAST:event_adicionaCursoButton1ActionPerformed

    private void deletaCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaCursoButtonActionPerformed

        DefaultTableModel cursosTabela = (DefaultTableModel) cursosTable.getModel();
        String cursoSelecionado = (String) cursosComboBox.getSelectedItem();

        if (cursosComboBox.getItemCount() > 0) {
            for (int i = 0; i < cursosTabela.getRowCount(); i++) {
                if (cursosTabela.getValueAt(i, 0).equals(cursoSelecionado)) {
                    for (Curso u : listaCurso) {
                        if (u.getDescricao().equals(cursoSelecionado)) {
                            //2 = removeu
                            //cursosTabela.removeRow(i);
                            Curso_Aluno curso = new Curso_Aluno(2, codigoAluno, u.codigo);
                            cursoAdicionadoOURemoveux.add(curso);
                        }
                    }
                    cursosTabela.removeRow(i);
                }
            }

        }

    }//GEN-LAST:event_deletaCursoButtonActionPerformed

    private void alunosTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunosTableMousePressed

        cursoAdicionadoOURemoveux = new ArrayList<Curso_Aluno>();
        //cursoAdicionadoOURemoveu = new Object[]{};

        linhaSelecionada = alunosTable.getSelectedRow();

        DefaultTableModel alunoTableModelo = (DefaultTableModel) alunosTable.getModel();
        DefaultTableModel cursoTableModelo = (DefaultTableModel) cursosTable.getModel();

        codigoAluno = Integer.parseInt(String.valueOf(alunoTableModelo.getValueAt(linhaSelecionada, 0)));
        String nomeAluno = String.valueOf(alunosTable.getValueAt(linhaSelecionada, 1));

        codigoAlunoTextField.setText(String.valueOf(codigoAluno));
        nomeAlunoTextField.setText(nomeAluno);

        cursoTableModelo.setRowCount(0);

        for (Curso_Aluno y : listaCurso_Aluno) {
            if (codigoAluno == y.codigo_aluno) {
                for (Curso u : listaCurso) {
                    if (codigoAluno == y.codigo_aluno && y.getCodigo_curso() == u.codigo) {
                        Object[] item = {u.getDescricao()};
                        cursoTableModelo.addRow(item);
                    }
                }
            }
            
        }

        //cursosComboBox.removeAllItems();
        /*for (Curso_Aluno u : listaCurso_Aluno) {
            if (codigoAluno == u.getCodigo_aluno()) {
                for (Curso y : listaCurso) {
                    Object[] item = {y.getDescricao()};
                    if (u.getCodigo_curso() == y.getCodigo()) {
                        
                        
                        cursoTableModelo.addRow(item);

                    }
                }
            }
        }*/

    }//GEN-LAST:event_alunosTableMousePressed

    private void excluirAlunoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirAlunoButtonActionPerformed
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um aluno");
        } else {
            try {
                try {
                    con = Conectadb.conectadb();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
                }
                stmt = con.createStatement();
                for (Aluno u : listaAluno) {
                    if (codigoAluno == u.getCodigo()) {
                        String scriptSqlAlunos2 = "DELETE FROM aluno "
                                + "WHERE codigo = " + u.getCodigo() + ";";
                        stmt.executeUpdate(scriptSqlAlunos2);
                    }
                }
                for (Curso_Aluno u : listaCurso_Aluno) {
                    if (codigoAluno == u.codigo_aluno) {
                        String scriptSqlAlunos2 = "DELETE FROM curso_aluno "
                                + "WHERE codigo = " + u.getCodigo() + ";";
                        stmt.executeUpdate(scriptSqlAlunos2);
                    }
                }

                CarregaTabelas();
                linhaSelecionada = -1;
                codigoAluno = -1;
                codigoAlunoTextField.setText("");
                nomeAlunoTextField.setText("");
                stmt.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_excluirAlunoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionaCursoButton1;
    private javax.swing.JTable alunosTable;
    private javax.swing.JButton atualizarAlunoButton;
    private javax.swing.JLabel cadastroAlunoLabel;
    private javax.swing.JLabel codigoAlunoLabel;
    private javax.swing.JTextField codigoAlunoTextField;
    private javax.swing.JComboBox<String> cursosComboBox;
    private javax.swing.JTable cursosTable;
    private javax.swing.JButton deletaCursoButton;
    private javax.swing.JButton excluirAlunoButton;
    private javax.swing.JLabel insiraAlunoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nomeAlunoLabel;
    private javax.swing.JTextField nomeAlunoTextField;
    private javax.swing.JLabel testeLabel;
    // End of variables declaration//GEN-END:variables
}
