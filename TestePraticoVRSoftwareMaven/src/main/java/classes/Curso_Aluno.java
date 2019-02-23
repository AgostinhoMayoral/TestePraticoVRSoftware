/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author tinho
 */
public class Curso_Aluno {
    
    public int codigo=0;
    public int codigo_aluno=0;
    public int codigo_curso=0;

    public Curso_Aluno(int codigo, int codigo_aluno, int codigo_curso) {
        this.codigo = codigo;
        this.codigo_aluno = codigo_aluno;
        this.codigo_curso = codigo_curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(int codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public int getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

 
    
}
