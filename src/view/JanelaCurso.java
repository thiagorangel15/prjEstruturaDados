package view;

import java.awt.EventQueue;
import model.Curso;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCurso extends JFrame {

	private JPanel contentPane;
	private JTextField tfCargaHoraria;
	private JTextField tfTipo;
	private JTextField tfNome;
	private JTextField tfCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCurso frame = new JanelaCurso();
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
	public JanelaCurso() {
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo: ");
		lblNewLabel_2.setBounds(10, 107, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Carga Horária:");
		lblNewLabel_3.setBounds(10, 152, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = tfCodigo.getText();
				String nome = tfNome.getText();
				String tipo = tfTipo.getText();
				String aux = tfCargaHoraria.getText();
				int cargaHoraria;
				
				try {
					cargaHoraria = Integer.parseInt(aux);
					
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk, "Idade Inválida: " + aux);
					return;
				}
				
				try {
					Curso c = new Curso(codigo,nome,tipo,cargaHoraria);
					JOptionPane.showMessageDialog(btOk, "Deu bom! " + c);
				}catch(Exception el) {
					JOptionPane.showMessageDialog(btOk, "Erro: " + el.getMessage());
					el.printStackTrace();
					return;
					
				}
				
			}
		});
		btOk.setBounds(50, 227, 89, 23);
		contentPane.add(btOk);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btFechar.setBounds(251, 227, 89, 23);
		contentPane.add(btFechar);
		
		tfCargaHoraria = new JTextField();
		tfCargaHoraria.setBounds(94, 149, 89, 20);
		contentPane.add(tfCargaHoraria);
		tfCargaHoraria.setColumns(10);
		
		tfTipo = new JTextField();
		tfTipo.setBounds(94, 104, 121, 20);
		contentPane.add(tfTipo);
		tfTipo.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(94, 58, 121, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(94, 20, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
	}

}
