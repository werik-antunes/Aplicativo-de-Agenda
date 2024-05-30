package agenda;

public class Contato {
		private String nome;
		private String telefone;
		private String email;

		public Contato(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;

		}

		@Override
		public String toString() {
		return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
		}

	}

