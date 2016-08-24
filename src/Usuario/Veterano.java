package Usuario;

import Jogo.Jogo;

public class Veterano extends Usuario {
	
	/**
	 * Construtor da classe veterano
	 * @param nome: nome do jogador veterano
	 * @param username: login do jogador veterano
	 * @throws Exception: lanca excecao quando nome ou username sao vazios ou nulos
	 */

	public Veterano(String nome, String username) throws Exception {
		super(nome, username);
		super.tipo = "Veterano";
		super.x2p = 1000;
	}
	
	/**
	 * O usuario veterano compra um jogo passando o proprio jogo como parametro
	 */
	
	public boolean compraJogos(Jogo jogo) {
		double descontoVeterano = 0.2;
		int x2pPorReal = 15;
		if (!jogos.contains(jogo)) {
			double valorJogo = jogo.getPreco() - (jogo.getPreco() * descontoVeterano);
			if (getSaldo() >= valorJogo) {
				jogos.add(jogo);
				compraJogo(valorJogo);
				double precoInteiro = jogo.getPreco() - (jogo.getPreco() % 1);
				x2p += precoInteiro * x2pPorReal;
				return true;
			}
		}
		return false;

	}
	
	/**
	 * O usuario veterano compra um jogo passando o nome, preco e tipo do jogo
	 */
	
	
	public boolean compraJogos(String nome, double preco, String tipo) throws Exception {
		Jogo jogo = factoryJogo.factoryJogo(nome, preco, tipo);
		double descontoVeterano = 0.2;
		int x2pPorReal = 15;
		if (!jogos.contains(jogo)) {
			double valorJogo = jogo.getPreco() - (jogo.getPreco() * descontoVeterano);
			if (getSaldo() >= valorJogo) {
				jogos.add(jogo);
				compraJogo(valorJogo);
				double precoInteiro = jogo.getPreco() - (jogo.getPreco() % 1);
				x2p += precoInteiro * x2pPorReal;
				return true;
			}
		}
		return false;

	}
	
	
}
