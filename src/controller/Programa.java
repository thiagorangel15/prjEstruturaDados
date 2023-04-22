package controller;

import view.JanelaPrincipal;
import model.Curso;
import model.Disciplina;
import model.Pessoa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Programa {

	public static void main(String[] args) {
		JanelaPrincipal janela = new JanelaPrincipal ();
		janela.setVisible(true);
	}
	
	public static void salvarObjetos() {		
		try {
			FileOutputStream   fos = new FileOutputStream("C:/Users/THIAGO/Documents/prjEstruturaDados/bin/Objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			if(Pessoa.getListaPessoas() != null) {
				oos.writeObject( Pessoa.getListaPessoas() );
			}
			if(Curso.getListaCursos() != null) {
				oos.writeObject( Curso.getListaCursos() );
			}
			if(Disciplina.getListaDisciplinas() != null) {
				oos.writeObject( Disciplina.getListaDisciplinas() );
			}
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		}				
	}

	public static void recuperarObjetos() {		
		try {
			FileInputStream   fis = new FileInputStream("C:/Users/THIAGO/Documents/prjEstruturaDados/bin/Objetos.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Pessoa.setListaPessoas( (Pessoa[]) ois.readObject() );
			Curso.setListaCursos( (Curso[]) ois.readObject());
			Disciplina.setListaDisciplinas( (Disciplina[]) ois.readObject());
			ois.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		}				
	}

}

