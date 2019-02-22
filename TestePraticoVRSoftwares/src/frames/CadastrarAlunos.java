package frames;

import java.sql.*;
import dal.Conectadb;
import java.util.logging.Level;
import java.util.logging.Logger;
import classes.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tinho
 */
public class CadastrarAlunos extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Curso> listaCursos = new ArrayList<Curso>();
    ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

    public CadastrarAlunos() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);

        CursosCadastrados();

    }

    public void CursosCadastrados() {

        try {
            con = Conectadb.conectadb();
            String scriptSqlCursos = "Select * FROM curso";
            stmt = con.createStatement();
            rs = stmt.executeQuery(scriptSqlCursos);
            String descricaoCurso = "";
            while (rs.next()) {
                descricaoCurso = rs.getString("descricao");
                cursosComboBox.addItem(descricaoCurso);
                Curso curso = new Curso(rs.getInt("codigo"), rs.getString("descricao"), rs.getString("ementa"));
                listaCursos.add(curso);
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
        codigoAlunoLabel = new javax.swing.JLabel();
        nomeAlunoLabel = new javax.swing.JLabel();
        nomeAlunoTextField = new javax.swing.JTextField();
        cursosComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        cursosTable = new javax.swing.JTable();
        salvarAlunoButton = new javax.swing.JButton();
        adicionaCursoButton = new javax.swing.JButton();
        insiraAlunoLabel = new javax.swing.JLabel();
        editaAlunoButton1 = new javax.swing.JButton();
        testeLabel = new javax.swing.JLabel();
        codigoAlunoFormattedTextField = new javax.swing.JFormattedTextField();
        removerCursoButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        codigoAlunoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codigoAlunoLabel.setText("Código:");

        nomeAlunoLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nomeAlunoLabel.setText("Nome:");

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

        salvarAlunoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salvarAlunoButton.setText("Salvar Novo Aluno");
        salvarAlunoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarAlunoButtonActionPerformed(evt);
            }
        });

        adicionaCursoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adicionaCursoButton.setText("+");
        adicionaCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaCursoButtonActionPerformed(evt);
            }
        });

        insiraAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insiraAlunoLabel.setText("Insira cursos ao Aluno");

        editaAlunoButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editaAlunoButton1.setText("Edita Alunos");
        editaAlunoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaAlunoButton1ActionPerformed(evt);
            }
        });

        testeLabel.setText("jLabel1");

        codigoAlunoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0"))));
        codigoAlunoFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        removerCursoButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removerCursoButton1.setText("-");
        removerCursoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerCursoButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigoAlunoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nomeAlunoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeAlunoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                    .addComponent(codigoAlunoFormattedTextField))
                                .addGap(122, 122, 122)
                                .addComponent(testeLabel)
                                .addGap(106, 106, 106))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(cursosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(adicionaCursoButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(removerCursoButton1))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(salvarAlunoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editaAlunoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(insiraAlunoLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoAlunoLabel)
                    .addComponent(codigoAlunoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeAlunoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeAlunoLabel)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(testeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insiraAlunoLabel)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cursosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerCursoButton1)
                    .addComponent(adicionaCursoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarAlunoButton)
                    .addComponent(editaAlunoButton1))
                .addContainerGap())
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
                .addContainerGap()
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


    private void editaAlunoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaAlunoButton1ActionPerformed
        new EditarAlunos().setVisible(true);
    }//GEN-LAST:event_editaAlunoButton1ActionPerformed

    private void salvarAlunoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarAlunoButtonActionPerformed
        try {
            
            if(!codigoAlunoFormattedTextField.getText().equals("".trim()) 
                    && !nomeAlunoTextField.getText().equals("".trim())){

            DefaultTableModel modeloCursosTable = (DefaultTableModel) cursosTable.getModel();

            con = Conectadb.conectadb();
            stmt = con.createStatement();
            int codigoAluno = Integer.parseInt(codigoAlunoFormattedTextField.getText());
            String scriptSqlAlunos = "Select * FROM aluno";
            rs = stmt.executeQuery(scriptSqlAlunos);
            boolean achou = false;
            while (rs.next()) {

                if (rs.getInt("codigo") == Integer.parseInt(codigoAlunoFormattedTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "Código existente");
                    achou = true;
                }
            }

            if (achou == false) {
                //Inserindo Aluno no Banco
                String scriptSqlAluno = "INSERT INTO aluno (codigo,nome) "
                        + "VALUES (" + codigoAluno + ", '" + nomeAlunoTextField.getText() + "')";
                stmt.executeUpdate(scriptSqlAluno);

                int cont = 0;

                //Adicionando Curso ao Aluno
                for (int i = 0; i < cursosTable.getRowCount(); i++) {
                    for (Curso u : listaCursos) {

                        if (cursosTable.getValueAt(i, 0).equals(u.getDescricao())) {

                            String scriptSqlAlunos2 = "INSERT INTO curso_aluno ( codigo_aluno, codigo_curso) "
                                    + "VALUES (" + codigoAluno + ", " + u.getCodigo() + ")";
                            stmt.executeUpdate(scriptSqlAlunos2);

                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");

                codigoAlunoFormattedTextField.setText("");
                nomeAlunoTextField.setText("");
                modeloCursosTable.setRowCount(0);
            }
            con.close();
            }else{
                JOptionPane.showMessageDialog(null, "Preencha o campo Código e Nome ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarAlunoButtonActionPerformed

    private void adicionaCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaCursoButtonActionPerformed
        DefaultTableModel cursosTabela = (DefaultTableModel) cursosTable.getModel();
        String cursoSelecionado = (String) cursosComboBox.getSelectedItem();

        
        if (cursosComboBox.getItemCount() > 0) {
            boolean achou = false;
            for (int i = 0; i < cursosTabela.getRowCount(); i++) {
                if (cursosTabela.getValueAt(i, 0).equals(cursoSelecionado)) {
                    achou =true;
                }
            }
            if(achou == false){
                    cursosTabela.addRow(new Object[]{cursoSelecionado});
            }

        }

    }//GEN-LAST:event_adicionaCursoButtonActionPerformed

    private void removerCursoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerCursoButton1ActionPerformed
        DefaultTableModel cursosTabela = (DefaultTableModel) cursosTable.getModel();
        String cursoSelecionado = (String) cursosComboBox.getSelectedItem();

        
        if (cursosComboBox.getItemCount() > 0) {
            for (int i = 0; i < cursosTabela.getRowCount(); i++) {
                if (cursosTabela.getValueAt(i, 0).equals(cursoSelecionado)) {
                    cursosTabela.removeRow(i);
                }
            }

        }
    }//GEN-LAST:event_removerCursoButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastrarAlunos().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CadastrarAlunos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionaCursoButton;
    private javax.swing.JFormattedTextField codigoAlunoFormattedTextField;
    private javax.swing.JLabel codigoAlunoLabel;
    private javax.swing.JComboBox<String> cursosComboBox;
    private javax.swing.JTable cursosTable;
    private javax.swing.JButton editaAlunoButton1;
    private javax.swing.JLabel insiraAlunoLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nomeAlunoLabel;
    private javax.swing.JTextField nomeAlunoTextField;
    private javax.swing.JButton removerCursoButton1;
    private javax.swing.JButton salvarAlunoButton;
    private javax.swing.JLabel testeLabel;
    // End of variables declaration//GEN-END:variables
}
