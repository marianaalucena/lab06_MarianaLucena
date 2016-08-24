package Jogo;

public class RPG extends Jogo {

	/**
	 * Construtor da classe RPG
	 * 
	 * @param nome:
	 *            nome do jogo de tipo RPG
	 * @param preco:
	 *            preço do jogo de tipo RPG
	 * @throws Exception:
	 *             lanca excecao quando o nome for nulo ou vazio, ou quando o
	 *             preco for negativo
	 */

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "RPG";

	}

	/**
	 * O metodo registra jogadas recebe o valor da pontuacao do usuario e um
	 * booleano para saber se este jogo foi zerado ou nao. Este metodo atualiza
	 * o valor da maior pontuacao e adiciona ao usuario seu valor de x2p.
	 */

	public int registraJogadas(int score, boolean zerou) {
		int x2pRPG = 10;
		setQntJogadas();
		if (score > getMaiorScore()) {
			setMaiorScore(score);
		}
		if (zerou) {
			setQntJogadas();
		}
		return x2pRPG;
	}

}
