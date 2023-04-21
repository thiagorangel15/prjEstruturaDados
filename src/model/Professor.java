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
    
    public String toString() {
        String resultado = "Meu nome é " + this.getNome();
        resultado += ", eu tenho " + this.getIdade() + " anos";
        resultado += " e meu cpf é " + this.getCpf();
        resultado += " e minha matricula funcional é " + this.matrFuncional;
        resultado += " e minha  titulação é " + this.titulacao;

        return resultado;
    }
}
