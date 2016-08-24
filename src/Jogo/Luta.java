package Jogo;

public class Luta extends Jogo{
	
	/**
	 *Construtor da classe luta
	 * @param nome: nome do jogo de tipo luta
	 * @param preco: preço do jogo de tipo luta
	 * @throws Exception: lanca excecao quando o nome for nulo ou vazio, ou quando o preco for negativo
	 */

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "Luta";
	}
	
	/**
	 * O metodo registra jogadas recebe o valor da pontuacao do usuario e um
	 * booleano para saber se este jogo foi zerado ou nao. Este metodo atualiza
	 * o valor da maior pontuacao e adiciona ao usuario seu valor de x2p.
	 */

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
