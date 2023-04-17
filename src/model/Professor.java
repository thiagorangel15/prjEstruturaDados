package model;

public class Professor extends Pessoa{
    private String matrFuncional;
    private String titulacao;
    public Professor(String cpf, String nome, int idade, String matrFuncional, String titulacao)throws Exception {
        super(cpf, nome, idade);
        setMatrFuncional(matrFuncional);
        setTitulacao(titulacao);
    }

    public String getMatrFuncional() {
        return matrFuncional;
    }

    public void setMatrFuncional(String matrFuncional) throws Exception {
        Validacao.validarMatrFuncional(matrFuncional);
        this.matrFuncional = matrFuncional;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao)throws Exception {
        Validacao.validarTitulacao(titulacao);
        this.titulacao = titulacao;
    }
}
