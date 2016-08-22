package Loja;

import java.util.HashSet;

import Jogo.Jogo;
import Usuario.FactoryUsuario;
import Usuario.Noob;
import Usuario.Usuario;

public class Fachada {
	private HashSet<Usuario> usuarios;
	private FactoryUsuario factoryUsuario;
	protected final String QUEBRA_LINHA = System.lineSeparator();

	public Fachada() {
		usuarios = new HashSet<>();
		factoryUsuario = new FactoryUsuario();

	}

	public boolean addUsuario(Usuario usuario) {
		if (!usuarios.contains(usuario)) {
			usuarios.add(usuario);
			return true;
		}
		return false;
	}

	public boolean addDinheiro(String username, double valor) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equals(username)) {
				usuario.addDinheiro(valor);
				return true;
			}
		}
		return false;

	}

	public boolean vendeJogo(String username, Jogo jogo) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equals(username)) {
				usuario.compraJogos(jogo);
				return true;
			}
		}
		return false;
	}

	public boolean removeUsuario(Usuario usuario) {
		if (usuarios.contains(usuario)) {
			usuarios.remove(usuario);
			return true;
		}
		return false;
	}

	public boolean removeUsuario(String username) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equalsIgnoreCase(username)) {
				usuarios.remove(usuario);
				return true;
			}
		}
		return false;
	}

	public boolean upgrade(String username) throws Exception {
		for (Usuario usuario : usuarios) {
			if (!usuario.getUsername().equals(username) && usuario.getX2p() >= 1000) {
				if (usuario instanceof Noob) {
					String tipo = "Veterano";
					Usuario newUsuario = factoryUsuario.factoryUsuario(usuario.getNome(), username, tipo);
					newUsuario.setSaldo(usuario.getSaldo());
					newUsuario.setX2p(usuario.getX2p());
					newUsuario.setJogos(usuario.getJogos());
					removeUsuario(usuario);
					addUsuario(newUsuario);
					return true;
				}
			} else {
				throw new Exception("Usuario ja veterano");
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factoryUsuario == null) ? 0 : factoryUsuario.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fachada other = (Fachada) obj;
		if (factoryUsuario == null) {
			if (other.factoryUsuario != null)
				return false;
		} else if (!factoryUsuario.equals(other.factoryUsuario))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	public String toString() {
		String retorno = "=== Central P2-CG ===";
		for (Usuario usuario : usuarios) {
			retorno += QUEBRA_LINHA + usuario.toString();
		}
		retorno += QUEBRA_LINHA + QUEBRA_LINHA + "--------------------------------------------";
		return retorno;
	}
}
