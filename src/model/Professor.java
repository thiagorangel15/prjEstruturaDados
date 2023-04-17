package model;

public class Professor extends Pessoa{
    private String matrFuncional;
    public Professor(String cpf, String nome, int idade, String matrFuncional) {
        super(cpf, nome, idade);
        setMatrFuncional(matrFuncional);
    }

    public String getMatrFuncional() {
        return matrFuncional;
    }

    public void setMatrFuncional(String matrFuncional) {
        this.matrFuncional = matrFuncional;
    }
}
