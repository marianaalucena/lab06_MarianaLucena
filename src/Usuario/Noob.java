package Usuario;

import Jogo.Jogo;

public class Noob extends Usuario {

	public Noob(String nome, String username) throws Exception {
		super(nome, username);
		super.tipo = "Noob";
		super.x2p = 0;
		
	}

	public boolean compraJogos(Jogo jogo) {
		double descontoNoob = 0.1;
		int x2pPorReal = 10;
		if (!jogos.contains(jogo)) {
			if (getSaldo() >= jogo.getPreco()) {
				jogos.add(jogo);
				compraJogo(jogo.getPreco() * descontoNoob);
				double precoInteiro = jogo.getPreco() - (jogo.getPreco() % 1);
				x2p += precoInteiro * x2pPorReal;
				return true;
			}
		}
		return false;

	}
	
	public boolean compraJogos(String nome, double preco, String tipo) throws Exception{
		double descontoNoob = 0.1;
		int x2pPorReal = 10;
		Jogo jogo = factoryJogo.factoryJogo(nome, preco, tipo);
		if(!jogos.contains(jogo)){
			if(getSaldo() >= jogo.getPreco()){
				jogos.add(jogo);
				compraJogo(jogo.getPreco() * descontoNoob);
				double precoInteiro = jogo.getPreco() - (jogo.getPreco() % 1);
				x2p += precoInteiro * x2pPorReal;
				return true;
			}
		} return false;
		
	}
}
