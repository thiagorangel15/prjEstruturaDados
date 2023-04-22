package model;

import java.io.Serializable;

public class Disciplina implements Serializable{
	
	final public static int NUM_MAX_DISCIPLINAS = 10;
	
    private String codigo;
    private String nome;
    private int numCreditos;
    
    private static Disciplina[] listaDisciplinas = new Disciplina[Disciplina.NUM_MAX_DISCIPLINAS];
    private static int numDisciplinas = 0;

    public Disciplina(String codigo, String nome, int numCreditos) throws Exception{
        setCodigo(codigo);
        setNome(nome);
        setNumCreditos(numCreditos);
        
        Disciplina.listaDisciplinas[Disciplina.numDisciplinas++] = this;
    }

    
    
    
    public static Disciplina[] getListaDisciplinas() {
		return listaDisciplinas;
	}




	public static void setListaDisciplinas(Disciplina[] listaDisciplinas) {
		Disciplina.listaDisciplinas = listaDisciplinas;
		
		for(int i = 0; i < Disciplina.NUM_MAX_DISCIPLINAS ; i++) {
			if(Disciplina.listaDisciplinas[i] != null)
				System.out.println(Disciplina.listaDisciplinas[i]);
			else {
				Disciplina.numDisciplinas = i;
				break;
			}
		}
	}




	public static int getNumDisciplinas() {
		return numDisciplinas;
	}




	public static void setNumDisciplinas(int numDisciplinas) {
		Disciplina.numDisciplinas = numDisciplinas;
	}




	public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws Exception {
        Validacao.validarCodigoDisciplina(codigo);
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
        Validacao.validarNome(nome);
        this.nome = nome;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) throws Exception {
        Validacao.validarNumCreditosDisciplina(numCreditos);
        this.numCreditos = numCreditos;
    }
    
    public String toString() {
        String resultado = "Meu codigo é " + this.codigo;
        resultado += " meu nome é " + this.nome;
        resultado += " meu numero de creditos é " + this.numCreditos;
        return resultado;
    }
}
