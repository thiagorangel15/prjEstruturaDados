package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Pessoa;

public class JanelaPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JButton btCancelar;

	/**
	 * Create the frame.
	 */
	public JanelaPessoa() {
		setTitle("Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF: ");
		lblNewLabel.setBounds(31, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(73, 29, 188, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(31, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(73, 67, 294, 17);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setBounds(31, 101, 46, 20);
		contentPane.add(lblNewLabel_2);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(73, 101, 86, 20);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = tfCpf.getText();
				String nome = tfNome.getText();
				String aux = tfIdade.getText();
				int idade;
				
				try {
					idade = Integer.parseInt(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk, "Idade Inválida: " + aux);
					return;
				}
				
				try {
					Pessoa p = new Pessoa(cpf, nome, idade);
					JOptionPane.showMessageDialog(btOk, "Deu bom! " + p);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btOk, "Erro: " + e1.getMessage());
					e1.printStackTrace();
					return;
				}				
			}
		});
		btOk.setBounds(89, 158, 89, 23);
		contentPane.add(btOk);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(253, 158, 89, 23);
		contentPane.add(btCancelar);
	}
}