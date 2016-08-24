package Usuario;

public class FactoryUsuario {
	
	/**
	 * 
	 * @param nome: nome do usuario
	 * @param username: login do usuario
	 * @param tipo: tipo do usuario
	 * @return: retorna um usuario
	 * @throws Exception
	 */
	
	
	public Usuario factoryUsuario(String nome, String username, String tipo) throws Exception{
		if(tipo.equalsIgnoreCase("Noob")){
			return new Noob(nome, username);
		}
		
		if(tipo.equalsIgnoreCase("Veterano")){
			return new Veterano(nome, username);
		} return null;
	}
}
