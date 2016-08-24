package Jogo;

public class FactoryJogo {
	
	public FactoryJogo(){
		
	}
	
	/**
	 * 
	 * @param nome: nome do jogo
	 * @param preco: preco do jogo
	 * @param tipo: tipo do jogo
	 * @return: retorna um jogo
	 * @throws Exception: lanca excecao
	 */
	
	public Jogo factoryJogo(String nome, double preco, String tipo) throws Exception{
		
		if(tipo.equalsIgnoreCase("RPG")){
			return new RPG(nome, preco);
		}
		
		else if(tipo.equalsIgnoreCase("Plataforma")){
			return new Plataforma(nome, preco);
		}
		
		else if(tipo.equalsIgnoreCase("Luta")){
			return new Luta(nome, preco);
		} return null;
	}
	
}
