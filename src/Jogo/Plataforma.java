package Jogo;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "Plataforma";

	}
	
	public int registraJogadas(int score, boolean zerou){
		int x2pPlataforma = 20;
		int jogadaSemX2p = 0;
		setQntJogadas();
		if (score > getMaiorScore()){
			setMaiorScore(score);			
		}
		if (zerou){
			setQntJogadas();
			return x2pPlataforma;
		} return jogadaSemX2p;
	}

}
