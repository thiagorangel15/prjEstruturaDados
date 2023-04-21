package view;

import java.awt.EventQueue;
import model.Aluno;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaAluno extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfIdade;
	private JTextField tfMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAluno frame = new JanelaAluno();
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
	public JanelaAluno() {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 49, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade: ");
		lblNewLabel_2.setBounds(10, 92, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matricula: ");
		lblNewLabel_3.setBounds(10, 136, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		tfNome = new JTextField();
		tfNome.setBounds(69, 8, 146, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(69, 46, 146, 20);
		contentPane.add(tfCPF);
		tfCPF.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(66, 89, 74, 20);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(69, 133, 146, 20);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JButton btOk = new JButton("Cadastrar");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome  = tfNome.getText();
				String cpf = tfCPF.getText();
				String matricula = tfMatricula.getText();
				String aux = tfIdade.getText();
				int idade;
				try {
					idade  = Integer.parseInt(aux);
					
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(btOk, "Idade Inválida: " + aux);
					return;
				}
				
				try {
					Aluno a = new Aluno(cpf,nome,idade,matricula);
					JOptionPane.showMessageDialog(btOk, "Aluno criado:  " + a);
					
				}catch(Exception el){
					JOptionPane.showMessageDialog(btOk, "Erro: " + el.getMessage());
					el.printStackTrace();
					return;
				}
				
			}
		});
		btOk.setBounds(87, 227, 128, 23);
		contentPane.add(btOk);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btFechar.setBounds(260, 227, 89, 23);
		contentPane.add(btFechar);
	}
}
