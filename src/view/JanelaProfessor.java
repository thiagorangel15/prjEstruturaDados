package view;

import java.awt.EventQueue;
import model.Professor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfCpf;
	private JTextField tfMatrFunc;
	private JTextField tfTitulacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaProfessor frame = new JanelaProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaProfessor() {
		setTitle("Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(120, 8, 144, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Idade: ");
		lblNewLabel_1.setBounds(10, 51, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(120, 48, 86, 20);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cpf: ");
		lblNewLabel_2.setBounds(10, 95, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(120, 92, 144, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Matricula Funcional:");
		lblNewLabel_3.setBounds(10, 144, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		tfMatrFunc = new JTextField();
		tfMatrFunc.setBounds(120, 141, 200, 20);
		contentPane.add(tfMatrFunc);
		tfMatrFunc.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String cpf = tfCpf.getText();
				String matrFunc = tfMatrFunc.getText();
				String aux = tfIdade.getText();
				String titulacao = tfTitulacao.getText();
				int idade;
				
				try {
					idade = Integer.parseInt(aux);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk, "Idade Inválida: " + aux);
					return;
				}
				
				try {
					Professor p = new Professor(cpf,nome,idade,matrFunc,titulacao);
					JOptionPane.showMessageDialog(btOk, "Professor criado: " + p);
					
				}catch(Exception el) {
					JOptionPane.showMessageDialog(btOk, "Erro: " + el.getMessage());
					el.printStackTrace();
					return;
				}
			}
		});
		btOk.setBounds(66, 227, 89, 23);
		contentPane.add(btOk);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btFechar.setBounds(282, 227, 89, 23);
		contentPane.add(btFechar);
		
		JLabel lblNewLabel_4 = new JLabel("Titulação:");
		lblNewLabel_4.setBounds(10, 184, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		tfTitulacao = new JTextField();
		tfTitulacao.setBounds(120, 181, 200, 20);
		contentPane.add(tfTitulacao);
		tfTitulacao.setColumns(10);
	}

}
