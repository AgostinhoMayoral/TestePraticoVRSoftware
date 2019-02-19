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

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
    ArrayList<Curso> listaCurso = new ArrayList<Curso>();
    ArrayList<Curso_Aluno> listaCurso_Aluno = new ArrayList<Curso_Aluno>();

    ArrayList<Curso> cursosRealizados = new ArrayList<Curso>();
    int[] linhas;
    int linhaSelecionada;
    int codigoCurso = -1;

    public EditarCursos() {
        initComponents();
        this.setLocationRelativeTo(null);
        CarregaUsuarios();
    }

    public void CarregaUsuarios() {
        DefaultTableModel tabelaCursos = (DefaultTableModel) cursosTable.getModel();

        try {
            con = Conectadb.conectadb();
            String scriptSqlCursos = "Select * FROM curso";
            stmt = con.createStatement();
            rs = stmt.executeQuery(scriptSqlCursos);
            String descricaoCurso = "";
            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("codigo"), rs.getString("descricao"), rs.getString("ementa"));
                listaCurso.add(curso);
                Object[] lista = {rs.getInt("codigo"), rs.getString("descricao"), rs.getString("ementa")};
                tabelaCursos.addRow(lista);
            }

            String scriptSqlAlunos2 = "Select * FROM aluno";
            rs = stmt.executeQuery(scriptSqlAlunos2);

            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("codigo"), rs.getString("nome"));
                listaAluno.add(aluno);
            }

            String scriptSqlCursos_Aluno = "Select * FROM curso_aluno";
            rs = stmt.executeQuery(scriptSqlCursos_Aluno);

            while (rs.next()) {
                Curso_Aluno curso_Aluno = new Curso_Aluno(rs.getInt("codigo"), rs.getInt("codigo_aluno"), rs.getInt("codigo_curso"));
                listaCurso_Aluno.add(curso_Aluno);
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursosTableMouseClicked(evt);
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

    private void cursosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTableMouseClicked
        try {
            con = Conectadb.conectadb();
            stmt = con.createStatement();
            linhaSelecionada = cursosTable.getSelectedRow();

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
                Object[] lista = {y.getNome()};
                alunoTableModelo.addRow(lista);

            }
            /*String nomeAluno = "";
            for (Curso_Aluno u : listaCurso_Aluno) {

                if (codigoCurso == u.getCodigo_curso()) {
                    
                    for(Aluno y : listaAluno){
                        nomeAluno = y.getNome();
                    }
                    for(int i=0; i<alunoTableModelo.getRowCount();i++){
                        
                        if(nomeAluno.equals(alunoTableModelo.getValueAt(i, 0))){
                            alunosTable.setRowSelectionInterval(i, 0);
                            if(alunosTable.getSelectedRow()>1){
                        alunosTable.addRowSelectionInterval(i, 0);
                            }
                        }
                    }
                    
                }            
            }*/

            String fff = "";
            String nomeAluno = "";
            for (Curso_Aluno u : listaCurso_Aluno) {

                if (codigoCurso == u.getCodigo_curso()) {
                    for (Aluno y : listaAluno) {
                        if (u.getCodigo_aluno() == y.getCodigo()) {
                            nomeAluno = y.getNome();
                            for (int i = 0; i < alunoTableModelo.getRowCount(); i++) {
                                if (nomeAluno.equals(alunosTable.getValueAt(i, 0))) {
                                    fff += nomeAluno;

                                    testejLabel1.setText(fff);
                                    //if(alunosTable.getSelectedRow()==0){
                                    // alunosTable.setRowSelectionInterval(i, i);
                                    // }else{
                                    alunosTable.getSelectionModel().addSelectionInterval(i, i);
                                    //alunosTable.addRowSelectionInterval(i, 0);

                                    // }
                                    nomeAluno = "";
                                    i = alunoTableModelo.getRowCount();

                                }
                            }
                        }
                    }
                }
            }
            /*for (Curso_Aluno u : listaCurso_Aluno) {

                    if (codigoCurso == u.getCodigo_curso()) {
                        if (u.getCodigo_aluno() == y.getCodigo()) {
                            Object[] item = {y.getNome()};
                            cursoTableModelo.addRow(item);


                        }
                    }
                }*/
            linhas = alunosTable.getSelectedRows();
            rs.close();
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cursosTableMouseClicked

    private void atualizaCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaCursoButtonActionPerformed
        try {
            DefaultTableModel alunoTableModel = (DefaultTableModel) alunosTable.getModel();
            int codigoCurso = Integer.parseInt(codigoCursoTextField.getText());
            con = Conectadb.conectadb();
            stmt = con.createStatement();
            String scriptUpdateDescricaoCurso = "UPDATE Curso SET descricao = '" + descricaoCursoTextField.getText() + "'"
                    + "WHERE codigo in (" + codigoCurso + ")";
            stmt.executeUpdate(scriptUpdateDescricaoCurso);
            String scriptUpdateEmentaCurso = "UPDATE Curso SET descricao = '" + ementaCursoTextArea.getText() + "'"
                    + "WHERE codigo in (" + codigoCurso + ")";
            stmt.executeUpdate(scriptUpdateEmentaCurso);

            int[] linhasUpdate = alunosTable.getSelectedRows();

            
            String scriptSqlAlunos2 = "DELETE FROM curso_aluno "
                                        + "WHERE codigo_ = " + codigoCurso + "";
                                stmt.executeUpdate(scriptSqlAlunos2);
            
            
           /* for (int i = 0; i < linhas.length; i++) {
                for (int j = 0; j < linhasUpdate.length;j++ ) {
                    if (linhas[i] == linhasUpdate[j]) {
                        
                    }
                }
            }*/
            /* int[] linhas = alunosTable.getSelectedRows();

            for (Aluno u : listaAluno) {
                for (int i = 0; i < linhas.length; i++) {
                    
                    if (u.getNome().equals(alunoTableModel.getValueAt(linhas[i], 0))) {
                        String scriptSqlAlunos2 = "INSERT INTO curso_aluno ( codigo_aluno, codigo_curso) "
                                + "VALUES (" + u.getCodigo() + ", " + codigoCurso + ")";
                        stmt.executeUpdate(scriptSqlAlunos2);
                    }
                }
            }*/
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_atualizaCursoButtonActionPerformed

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
