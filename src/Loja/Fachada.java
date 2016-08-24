package Loja;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Jogo.Jogo;
import Usuario.FactoryUsuario;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class Fachada {
	private Set<Usuario> usuarios;
	private FactoryUsuario factoryUsuario;
	protected final String QUEBRA_LINHA = System.lineSeparator();

	/**
	 * Construtor da classe fachada
	 */

	public Fachada() {
		usuarios = new HashSet<Usuario>();
		factoryUsuario = new FactoryUsuario();

	}

	/**
	 * Adiciona um novo usuário a lista de usuários que tem dentro da
	 * loja/fachada, primeiro verifica-se se este usuario nao esta na lista e
	 * depois, se ele nao estiver la, o adiciona.
	 * 
	 * @param usuario:
	 *            o usuario a ser adicionado nessa lista
	 * @return: retorna um booleano para saber se adicionou o usuario
	 */

	public boolean addUsuario(Usuario usuario) {
		if (!usuarios.contains(usuario)) {
			usuarios.add(usuario);
			return true;
		}
		return false;
	}

	/**
	 * Este metodo adiciona dinheiro na conta do usuario
	 * 
	 * @param username:
	 *            o login do usuario
	 * @param valor:
	 *            o valor a ser adicionado na conta
	 * @return: retorna um booleano para saber se adicionou dinheiro
	 * @throws Exception:
	 *             lança excecao quando o valor a ser adicionado na conta for
	 *             negativo
	 */

	public boolean addDinheiro(String username, double valor) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equalsIgnoreCase(username)) {
				usuario.addDinheiro(valor);
				return true;
			}
		}
		return false;

	}

	/**
	 * Este metodo vende um jogo e chama o metodo de usuario "compraJogos" para
	 * comprar um jogo da loja
	 * 
	 * @param username:
	 *            o login do usuario
	 * @param jogo:
	 *            o nome do jogo a ser comprado pelo usuario
	 * @return: retorna um booleano
	 */

	public boolean vendeJogo(String username, Jogo jogo) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equals(username)) {
				usuario.compraJogos(jogo);
				return true;
			}
		}
		return false;
	}

	/**
	 * Este metodo remove um usuario da lista de usuarios presente na loja
	 * 
	 * @param usuario:
	 *            o usuario a ser removido da lista
	 * @return: retorna um booleano que indica se o usuario foi removido
	 */

	public boolean removeUsuario(Usuario usuario) {
		for (Usuario user : usuarios) {
			if (user.equals(usuario)) {
				usuarios.remove(user);
				return true;
			}
		}return false;
	}

	/**
	 * Remove o usuario so que dessa vez tomando como parametro o login do
	 * usuario
	 * 
	 * @param username:
	 *            o login do usuario a ser removido da lista de usuarios
	 * @return: retorna um booleano que indica se o usuario foi removido
	 */

	public boolean removeUsuario(String username) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equalsIgnoreCase(username)) {
				return usuarios.remove(usuario);

			}
		}
		return false;
	}
	
	/**
	 * Procura um usuario na lista de usuarios, recebendo como parametro o seu login
	 * @param username: login do usuario
	 * @return: retorna um usuario
	 */

	public Usuario buscaUsuario(String username) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equalsIgnoreCase(username)) {
				return usuario;
			}
		}
		return null;
	}

	/**
	 * Este metodo transforma um usuario noob em um veterano, fazendo um cast e
	 * pegando todos os atributos do usuario noob e passando para um usuario
	 * veterano, apos isso remove o antigo usuario noob
	 * 
	 * @param username:
	 *            o login do usuario a ser removido
	 * @return
	 * @throws Exception:
	 *             lanca excecao quando este usuario ja for um usuario veterano
	 */

	public boolean upgrade(String username) throws Exception {
		Usuario user = buscaUsuario(username);
		if (user != null && !(user instanceof Veterano)) {
			if (user.getX2p() >= 1000) {
				Usuario novoUsuario = factoryUsuario.factoryUsuario(user.getNome(), username, "Veterano");
				novoUsuario.setSaldo(user.getSaldo());
				novoUsuario.setJogos(user.getJogos());
				novoUsuario.setX2p(user.getX2p());
				removeUsuario(user);
				addUsuario(novoUsuario);
				return true;

			} else {
				throw new Exception("Usuario jah eh veterano");
			}
		}

		return false;

	}

	public HashSet<Usuario> getUsuarios() {
		return (HashSet<Usuario>) usuarios;
	}

	public void setUsuarios(HashSet<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public FactoryUsuario getFactoryUsuario() {
		return factoryUsuario;
	}

	public void setFactoryUsuario(FactoryUsuario factoryUsuario) {
		this.factoryUsuario = factoryUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factoryUsuario == null) ? 0 : factoryUsuario.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
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
