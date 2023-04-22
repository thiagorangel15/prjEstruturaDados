package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Programa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Principal ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btPessoa = new JButton("Pessoa");
		btPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPessoa jp = new JanelaPessoa();
				jp.setVisible(true);
			}
		});
		btPessoa.setBounds(38, 45, 89, 23);
		contentPane.add(btPessoa);
		
		JButton btAluno = new JButton("Aluno");
		btAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaAluno ja = new JanelaAluno();
				ja.setVisible(true);
			}
		});
		btAluno.setBounds(160, 45, 89, 23);
		contentPane.add(btAluno);
		
		JButton btProfessor = new JButton("Professor");
		btProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaProfessor jp = new JanelaProfessor();
				jp.setVisible(true);
			}
		});
		btProfessor.setBounds(283, 45, 89, 23);
		contentPane.add(btProfessor);
		
		JButton btCurso = new JButton("Curso");
		btCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCurso jc = new JanelaCurso();
				jc.setVisible(true);
			}
		});
		btCurso.setBounds(38, 110, 89, 23);
		contentPane.add(btCurso);
		
		JButton btDisciplina = new JButton("Disciplina");
		btDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaDisciplina jd = new JanelaDisciplina();
				jd.setVisible(true);
			}
		});
		btDisciplina.setBounds(160, 110, 89, 23);
		contentPane.add(btDisciplina);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Programa.salvarObjetos();
				System.exit(0);
			}
		});
		btSair.setBounds(283, 110, 89, 23);
		contentPane.add(btSair);
	}

}