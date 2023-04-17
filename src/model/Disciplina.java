package model;

public class Disciplina {
    private String codigo;
    private String nome;
    private int numCreditos;

    public Disciplina(String codigo, String nome, int numCreditos){
        setCodigo(codigo);
        setNome(nome);
        setNumCreditos(numCreditos);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }
}
