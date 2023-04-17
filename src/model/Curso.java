package model;

public class Curso {
    private String codigo;
    private String nome;
    private String tipo;
    private int cargaHoraria;

    public Curso(String codigo, String nome, String tipo, int cargaHoraria) throws Exception{
        setCodigo(codigo);
        setNome(nome);
        setTipo(tipo);
        setCargaHoraria(cargaHoraria);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws Exception {
        Validacao.validarCodigoCurso(codigo);
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        Validacao.validarNome(nome);
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void validarCargaHoraria(int cargaHoraria) throws Exception{
        if(this.tipo == "Curso Superior de Tecnologia"){
           if(cargaHoraria < 1400 && cargaHoraria > 2800){
               throw new Exception("Carga horária inválida para "+this.tipo);
           }
        }
        if(this.tipo == "Bacharelado"){
            if(cargaHoraria < 3000 && cargaHoraria > 6400){
                throw new Exception("Carga horária inválida para "+this.tipo);
            }
        }
        if(this.tipo == "Licenciatura"){
            if(cargaHoraria < 2880 && cargaHoraria > 3400){
                throw new Exception("Carga horária inválida para "+this.tipo);
            }
        }
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) throws Exception {
        validarCargaHoraria(cargaHoraria);
        this.cargaHoraria = cargaHoraria;
    }
}
