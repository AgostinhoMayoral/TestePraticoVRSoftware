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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author tinho
 */
public class EditarCursos extends javax.swing.JFrame {

    Conectadb conectaDBOjb = new Conectadb();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
    ArrayList<Curso> listaCurso = new ArrayList<Curso>();
    ArrayList<Curso_Aluno> listaCurso_Aluno = new ArrayList<Curso_Aluno>();
    ArrayList<Curso_Aluno> alunoAdicionadoOURemoveux = new ArrayList<Curso_Aluno>();

    int linhaSelecionada = -1;
    int codigoCurso = -1;

    public EditarCursos() {
        initComponents();
        this.setLocationRelativeTo(null);
        CarregaDadosAtuais();
    }

    public void CarregaDadosAtuais() {
        try {

            DefaultTableModel tabelaCursos = (DefaultTableModel) cursosTable.getModel();
            DefaultTableModel tabelaAlunos = (DefaultTableModel) alunosTable.getModel();
            tabelaCursos.setRowCount(0);
            tabelaAlunos.setRowCount(0);
            listaCurso = conectaDBOjb.selectListaCursosDB();
            listaAluno = conectaDBOjb.selectListaAlunosDB();
            listaCurso_Aluno = conectaDBOjb.selectListaCurso_AlunoDB();

            for (Curso u : listaCurso) {
                tabelaCursos.addRow(new Object[]{u.codigo, u.descricao, u.ementa});
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarCursos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cursosTable = new javax.swing.JTable();
        cadastroCursoLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ementaCursoLabel = new javax.swing.JLabel();
        atualizaCursoButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ementaCursoTextArea = new javax.swing.JTextArea();
        excluiCursoButton = new javax.swing.JButton();
        codigoCursoTextField = new javax.swing.JTextField();
        descricaoCursoTextField = new javax.swing.JTextField();
        codigoCursoLabel = new javax.swing.JLabel();
        descricaoCursoLabel = new javax.swing.JLabel();
        selecionaAlunoLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alunosTable = new javax.swing.JTable();
        testejLabel1 = new javax.swing.JLabel();
        selecionaAlunoLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cursosTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cursosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Ementa"
            }
        ));
        cursosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cursosTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(cursosTable);

        cadastroCursoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cadastroCursoLabel.setText("Clique no Curso Cadastrado para Atualizar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cadastroCursoLabel)
                        .addContainerGap(615, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cadastroCursoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        ementaCursoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ementaCursoLabel.setText("Ementa:");

        atualizaCursoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        atualizaCursoButton.setText("Atualizar");
        atualizaCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaCursoButtonActionPerformed(evt);
            }
        });

        ementaCursoTextArea.setColumns(20);
        ementaCursoTextArea.setRows(5);
        jScrollPane2.setViewportView(ementaCursoTextArea);

        excluiCursoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        excluiCursoButton.setText("Excluir");
        excluiCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluiCursoButtonActionPerformed(evt);
            }
        });

        codigoCursoTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codigoCursoTextField.setEnabled(false);

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
                "Código", "Alunos"
            }
        ));
        alunosTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(alunosTable);

        testejLabel1.setText("jLabel1");

        selecionaAlunoLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        selecionaAlunoLabel1.setText("Mantenha a tecla Ctrl pressionada e clique para marcar ou desmarcar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(codigoCursoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(descricaoCursoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ementaCursoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(testejLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(atualizaCursoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluiCursoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(codigoCursoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2)
                    .addComponent(descricaoCursoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selecionaAlunoLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(selecionaAlunoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(selecionaAlunoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selecionaAlunoLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigoCursoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codigoCursoLabel)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descricaoCursoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descricaoCursoLabel))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ementaCursoLabel)
                                .addGap(57, 57, 57)
                                .addComponent(testejLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(atualizaCursoButton)
                            .addComponent(excluiCursoButton)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizaCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaCursoButtonActionPerformed
        if (linhaSelecionada != -1) {
            try {

                DefaultTableModel alunoTableModel = (DefaultTableModel) alunosTable.getModel();
                codigoCurso = Integer.parseInt(codigoCursoTextField.getText());
                con = Conectadb.conectadb();
                stmt = con.createStatement();
                String scriptUpdateDescricaoCurso = "UPDATE Curso SET descricao = '" + descricaoCursoTextField.getText()
                        + "', ementa = '" + ementaCursoTextArea.getText() + "' WHERE codigo in (" + codigoCurso + ")";
                stmt.executeUpdate(scriptUpdateDescricaoCurso);

                for (int i = 0; i < alunosTable.getRowCount(); i++) {
                    boolean achou = false;
                    if (alunosTable.getSelectionModel().isSelectedIndex(i)) {
                        for (Curso_Aluno u : alunoAdicionadoOURemoveux) {
                            if (u.getCodigo_aluno() == Integer.parseInt(String.valueOf(alunosTable.getValueAt(i, 0)))) {
                                achou = true;
                            }
                        }
                        if (achou == false) {
                            String scriptSqlAluno = "INSERT INTO curso_aluno (codigo_aluno,codigo_curso) "
                                    + "VALUES (" + alunosTable.getValueAt(i, 0) + ", " + codigoCurso + ");";
                            stmt.executeUpdate(scriptSqlAluno);
                        }
                    }
                }

                for (Curso_Aluno u : alunoAdicionadoOURemoveux) {
                    boolean achou = false;
                    for (int i = 0; i < alunoTableModel.getRowCount(); i++) {
                        if (Integer.parseInt(String.valueOf(alunoTableModel.getValueAt(i, 0))) == u.codigo_aluno
                                && !alunosTable.getSelectionModel().isSelectedIndex(i)) {
                            achou = true;
                        }
                    }
                    if (achou == true) {
                        String scriptSqlAlunos2 = "DELETE FROM curso_aluno "
                                + "WHERE codigo = " + u.getCodigo() + ";";
                        stmt.executeUpdate(scriptSqlAlunos2);
                    }
                }
                CarregaDadosAtuais();
                linhaSelecionada = -1;
                codigoCurso = -1;
                codigoCursoTextField.setText("");
                descricaoCursoTextField.setText("");
                ementaCursoTextArea.setText("");
                stmt.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Cadastro atualizado");

            } catch (SQLException ex) {
                Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um curso");
        }
    }//GEN-LAST:event_atualizaCursoButtonActionPerformed

    private void cursosTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTableMousePressed
        linhaSelecionada = cursosTable.getSelectedRow();
        alunoAdicionadoOURemoveux = new ArrayList<Curso_Aluno>();
        DefaultTableModel alunoTableModelo = (DefaultTableModel) alunosTable.getModel();
        DefaultTableModel cursoTableModelo = (DefaultTableModel) cursosTable.getModel();
        codigoCurso = Integer.parseInt(String.valueOf(cursoTableModelo.getValueAt(linhaSelecionada, 0)));
        String descricaoCurso = String.valueOf(cursoTableModelo.getValueAt(linhaSelecionada, 1));
        String ementaCurso = String.valueOf(cursoTableModelo.getValueAt(linhaSelecionada, 2));
        codigoCursoTextField.setText(String.valueOf(codigoCurso));
        descricaoCursoTextField.setText(descricaoCurso);
        ementaCursoTextArea.setText(ementaCurso);

        alunoTableModelo.setRowCount(0);

        for (Aluno y : listaAluno) {
            Object[] lista = {y.codigo, y.getNome()};
            alunoTableModelo.addRow(lista);
        }
        String x = "";
        for (Curso_Aluno u : alunoAdicionadoOURemoveux) {
            x = x + u.getCodigo_aluno() + "\n";
        }

        String fff = "";
        String nomeAluno = "";
        for (Curso_Aluno u : listaCurso_Aluno) {
            if (codigoCurso == u.getCodigo_curso()) {
                for (Aluno y : listaAluno) {
                    if (u.getCodigo_aluno() == y.getCodigo()) {
                        nomeAluno = y.getNome();
                        for (int i = 0; i < alunoTableModelo.getRowCount(); i++) {
                            if (nomeAluno.equals(alunosTable.getValueAt(i, 1))) {
                                fff += nomeAluno;
                                alunosTable.getSelectionModel().addSelectionInterval(i, i);

                                nomeAluno = "";
                                i = alunoTableModelo.getRowCount();
                                alunoAdicionadoOURemoveux.add(u);
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_cursosTableMousePressed

    private void excluiCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluiCursoButtonActionPerformed
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um curso");
        } else {
            try {
                try {
                    con = Conectadb.conectadb();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
                }
                stmt = con.createStatement();
                for (Curso u : listaCurso) {
                    if (codigoCurso == u.getCodigo()) {
                        String scriptSqlCurso = "DELETE FROM curso "
                                + "WHERE codigo = " + codigoCurso + ";";
                        stmt.executeUpdate(scriptSqlCurso);
                    }
                }
                for (Curso_Aluno u : listaCurso_Aluno) {
                    if (codigoCurso == u.codigo_curso) {
                        String scriptSqlCurso2 = "DELETE FROM curso_aluno "
                                + "WHERE codigo = " + u.getCodigo() + ";";
                        stmt.executeUpdate(scriptSqlCurso2);
                    }
                }

                CarregaDadosAtuais();
                linhaSelecionada = -1;
                codigoCurso = -1;
                codigoCursoTextField.setText("");
                descricaoCursoTextField.setText("");
                ementaCursoTextArea.setText("");
                stmt.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Curso deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_excluiCursoButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alunosTable;
    private javax.swing.JButton atualizaCursoButton;
    private javax.swing.JLabel cadastroCursoLabel;
    private javax.swing.JLabel codigoCursoLabel;
    private javax.swing.JTextField codigoCursoTextField;
    private javax.swing.JTable cursosTable;
    private javax.swing.JLabel descricaoCursoLabel;
    private javax.swing.JTextField descricaoCursoTextField;
    private javax.swing.JLabel ementaCursoLabel;
    private javax.swing.JTextArea ementaCursoTextArea;
    private javax.swing.JButton excluiCursoButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel selecionaAlunoLabel;
    private javax.swing.JLabel selecionaAlunoLabel1;
    private javax.swing.JLabel testejLabel1;
    // End of variables declaration//GEN-END:variables
}
