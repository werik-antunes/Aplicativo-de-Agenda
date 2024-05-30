package agenda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AgendaSwing extends JFrame implements ActionListener {

	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextArea txtAreaContatos;
	private JButton btnAdicionar;
	private JButton btnLimpar;
	private ArrayList<Contato> contatos;

	public AgendaSwing() {

		setTitle("Aplicativo de Agenda");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		contatos = new ArrayList<>();

		JPanel painelFormulario = new JPanel(new GridLayout(4, 2));

		painelFormulario.add(new JLabel("Nome:"));
		txtNome = new JTextField();
		painelFormulario.add(txtNome);
		painelFormulario.add(new JLabel("Telefone:"));
		txtTelefone = new JTextField();
		painelFormulario.add(txtTelefone);
		painelFormulario.add(new JLabel("Email:"));
		txtEmail = new JTextField();
		painelFormulario.add(txtEmail);

		JPanel painelBotoes = new JPanel(new FlowLayout());

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		painelBotoes.add(btnAdicionar);
		painelBotoes.add(btnLimpar);

		txtAreaContatos = new JTextArea();
		txtAreaContatos.setEditable(false);

		add(painelFormulario, BorderLayout.NORTH);
		add(painelBotoes, BorderLayout.CENTER);
		add(new JScrollPane(txtAreaContatos), BorderLayout.SOUTH);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAdicionar) {

			String nome = txtNome.getText();
			String telefone = txtTelefone.getText();
			String email = txtEmail.getText();
			Contato contato = new Contato(nome, telefone, email);
			contatos.add(contato);
			atualizarListaContatos();
			limparCampos();

		} else if (e.getSource() == btnLimpar) {
			limparCampos();

		}
	}

	private void atualizarListaContatos() {

		txtAreaContatos.setText("");
		for (Contato contato : contatos) {
			txtAreaContatos.append(contato.toString() + "\n");

		}

	}

	private void limparCampos() {

		txtNome.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtNome.requestFocus();

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override

			public void run() {
				new AgendaSwing();

			}

		});

	}

}
