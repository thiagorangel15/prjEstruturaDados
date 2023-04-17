package model;

public class Curso {
    private String codigo;
    private String nome;
    private String tipo;
    private int cargaHoraria;

    public Curso(String codigo, String nome, String tipo, int cargaHoraria){
        setCodigo(codigo);
        setNome(nome);
        setTipo(tipo);
        setCargaHoraria(cargaHoraria);
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
