package model;

public class Aluno extends Pessoa{
    private String matr;
    public Aluno(String cpf, String nome, int idade, String matr) throws Exception {
        super(cpf, nome, idade);
        setMatr(matr);
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) throws Exception {
        Validacao.validarMatriculaAluno(matr);
        this.matr = matr;
    }
}
