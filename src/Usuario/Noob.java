package Usuario;

import Jogo.Jogo;

public class Noob extends Usuario {
	
	/**
	 * Construtor da classe noob
	 * @param nome: nome do jogador noob
	 * @param username: login do jogador noob
	 * @throws Exception: lanca excecao quando nome ou username sao vazios ou nulos
	 */

	public Noob(String nome, String username) throws Exception {
		super(nome, username);
		super.tipo = "Noob";
		super.x2p = 0;
		
	}
	
	/**
	 * O usuario noob compra um jogo passando o proprio jogo como parametro
	 */

	public boolean compraJogos(Jogo jogo) {
		double descontoNoob = 0.1;
		int x2pPorReal = 10;
		if (!jogos.contains(jogo)) {
			double valorJogo = jogo.getPreco() - (jogo.getPreco() * descontoNoob);
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
	 * O usuario noob compra um jogo passando o nome, preco e tipo do jogo
	 */
	
	public boolean compraJogos(String nome, double preco, String tipo) throws Exception{
		double descontoNoob = 0.1;
		int x2pPorReal = 10;
		Jogo jogo = factoryJogo.factoryJogo(nome, preco, tipo);
		if(!jogos.contains(jogo)){
			double valorJogo = jogo.getPreco() - (jogo.getPreco() * descontoNoob);
			if(getSaldo() >= valorJogo){
				jogos.add(jogo);
				compraJogo(valorJogo);
				double precoInteiro = jogo.getPreco() - (jogo.getPreco() % 1);
				x2p += precoInteiro * x2pPorReal;
				return true;
			}
		} return false;
		
	}
}
