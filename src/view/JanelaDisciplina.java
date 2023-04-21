package view;

import java.awt.EventQueue;
import model.Disciplina;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumCreditos;
	private JTextField tfNome;
	private JTextField tfCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDisciplina frame = new JanelaDisciplina();
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
	public JanelaDisciplina() {
		setTitle("Disciplina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(10, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setBounds(10, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Num Creditos:");
		lblNewLabel_2.setBounds(10, 121, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		tfNumCreditos = new JTextField();
		tfNumCreditos.setBounds(91, 118, 96, 20);
		contentPane.add(tfNumCreditos);
		tfNumCreditos.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(91, 66, 141, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(91, 19, 141, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String codigo = tfCodigo.getText();
				String aux = tfNumCreditos.getText();
				int numCreditos;
				
				try {
					numCreditos = Integer.parseInt(aux);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk, "Idade Inválida: " + aux);
					return;
				}
				
				try {
					Disciplina d = new Disciplina(codigo,nome,numCreditos);
					JOptionPane.showMessageDialog(btOk, "Disciplina criada: " + d);
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk, "Erro: " + e1.getMessage());
					e1.printStackTrace();
					return;
					
				}
			}
		});
		btOk.setBounds(38, 227, 89, 23);
		contentPane.add(btOk);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btFechar.setBounds(267, 227, 89, 23);
		contentPane.add(btFechar);
	}

}
