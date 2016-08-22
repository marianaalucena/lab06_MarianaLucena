package Usuario;

public class FactoryUsuario {
	
	
	public Usuario factoryUsuario(String nome, String username, String tipo) throws Exception{
		if(tipo.equalsIgnoreCase("Noob")){
			return new Noob(nome, username);
		}
		
		else if(tipo.equalsIgnoreCase("Veterano")){
			return new Veterano(nome, username);
		} return null;
	}
}
