package Jogo;

public class RPG extends Jogo {

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "RPG";
		
	}
	
	public int registraJogadas(int score, boolean zerou){
		int x2pRPG = 10;
		setQntJogadas();
		if (score > getMaiorScore()){
			setMaiorScore(score);	
		}
		if (zerou){
			setQntJogadas();
		} 	return x2pRPG;
	}
	

}
