package Jogo;

public class Luta extends Jogo{

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "Luta";
	}

	public int registraJogadas(int score, boolean zerou){
		int novoScoreAlcancado = 1000;
		setQntJogadas();
		if (score > 100000){
			score = 100000;
			
		}
		if (score > getMaiorScore()){
			setMaiorScore(score);
		}
		if (zerou){
			setQntJogadas();
		} return score / novoScoreAlcancado;
	}
	
}
