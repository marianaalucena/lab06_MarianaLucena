package Jogo;

public class Plataforma extends Jogo {
	
	/**
	 *Construtor da classe plataforma
	 * @param nome: nome do jogo de tipo plataforma
	 * @param preco: preço do jogo de tipo plataforma
	 * @throws Exception: lanca excecao quando o nome for nulo ou vazio, ou quando o preco for negativo
	 */

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "Plataforma";

	}
	
	/**
	 * O metodo registra jogadas recebe o valor da pontuacao do usuario e um
	 * booleano para saber se este jogo foi zerado ou nao. Este metodo atualiza
	 * o valor da maior pontuacao e adiciona ao usuario seu valor de x2p.
	 */
	
	public int registraJogadas(int score, boolean zerou){
		int x2pPlataforma = 20;
		int jogadaSemX2p = 0;
		setQntJogadas();
		if(score > getMaiorScore()){
			setMaiorScore(score);
		}
		if(zerou){
			setQntConclusoes();
			return x2pPlataforma;
		} return jogadaSemX2p;
	}

}
