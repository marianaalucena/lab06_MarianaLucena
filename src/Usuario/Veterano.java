package Usuario;

import Jogo.Jogo;

public class Veterano extends Usuario {

	public Veterano(String nome, String username) throws Exception {
		super(nome, username);
		super.tipo = "Veterano";
		super.x2p = 1000;
	}
	
	public boolean compraJogos(Jogo jogo) {
		double descontoVeterano = 0.2;
		int x2pPorReal = 15;
		if (!jogos.contains(jogo)) {
			if (getSaldo() >= jogo.getPreco()) {
				jogos.add(jogo);
				compraJogo(jogo.getPreco() * descontoVeterano);
				double precoInteiro = jogo.getPreco() - (jogo.getPreco() % 1);
				x2p += precoInteiro * x2pPorReal;
				return true;
			}
		}
		return false;

	}
	
	public boolean compraJogos(String nome, double preco, String tipo) throws Exception {
		Jogo jogo = factoryJogo.factoryJogo(nome, preco, tipo);
		double descontoVeterano = 0.2;
		int x2pPorReal = 15;
		if (!jogos.contains(jogo)) {
			if (getSaldo() >= jogo.getPreco()) {
				jogos.add(jogo);
				compraJogo(jogo.getPreco() * descontoVeterano);
				double precoInteiro = jogo.getPreco() - (jogo.getPreco() % 1);
				x2p += precoInteiro * x2pPorReal;
				return true;
			}
		}
		return false;

	}
	
	
}