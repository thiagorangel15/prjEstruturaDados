package model;

import java.io.Serializable;

public class Curso implements Serializable {
	
	final public static int NUM_MAX_CURSOS = 10;
	
    private String codigo;
    private String nome;
    private String tipo;
    private int cargaHoraria;
    
    private static Curso[] listaCursos = new Curso[Curso.NUM_MAX_CURSOS];
    private static int numCursos = 0;
    		

    public Curso(String codigo, String nome, String tipo, int cargaHoraria) throws Exception{
        setCodigo(codigo);
        setNome(nome);
        setTipo(tipo);
        setCargaHoraria(cargaHoraria);
        
        Curso.listaCursos[Curso.numCursos++] = this;
    }
    
    

    public static Curso[] getListaCursos() {
		return listaCursos;
	}



	public static void setListaCursos(Curso[] listaCursos) {
		Curso.listaCursos = listaCursos;
		
		for(int i = 0; i < Curso.NUM_MAX_CURSOS; i++) {
			if(Curso.listaCursos[i] != null)
				System.out.println(Curso.listaCursos[i]);
			else {
				Curso.numCursos = i;
				break;
			}
		}
	}



	public static int getNumCursos() {
		return numCursos;
	}



	public static void setNumCursos(int numCursos) {
		Curso.numCursos = numCursos;
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
        if(this.tipo.equals("Curso Superior de Tecnologia")){
           if(cargaHoraria < 1400 || cargaHoraria > 2800){
               throw new Exception("Carga horária inválida para "+this.tipo + " precisa ser entre 1400 e 2800");
           }
        }
        if(this.tipo.equals("Bacharelado")){
            if(cargaHoraria < 3000 || cargaHoraria > 6400){
                throw new Exception("Carga horária inválida para "+this.tipo + " precisa ser entre 3000  e 6400");
            }
        }
        if(this.tipo.equals("Licenciatura")){
            if(cargaHoraria < 2880 || cargaHoraria > 3400){
                throw new Exception("Carga horária inválida para "+this.tipo +  " precisa ser entre 2880 e 3400");
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
    
    public String toString() {
        String resultado = "Meu codigo é " + this.codigo;
        resultado += " meu nome é " + this.nome;
        resultado += " meu tipo é " + this.tipo;
        resultado += " minha carga horaria é " + this.cargaHoraria;
        return resultado;
    }
}
