package Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.RPG;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class TesteUsuario {
	
	private Usuario mariana;
	private Usuario igor;
	private Usuario helena;
	
	@Before
	public void setUp() throws Exception{
		mariana = new Noob("Mariana Lucena", "marianalucena");
		igor = new Veterano("Igor Lucena", "igorlucena");
		helena = new Noob("Helena Dantas", "helenadantas");
		
	}
	
	@Test
	public void testUsuario() throws Exception{
		assertEquals(0, mariana.getX2p());
		assertEquals(1000, igor.getX2p());
		assertEquals(0,helena.getX2p());
		assertEquals("Mariana Lucena", mariana.getNome());
		assertEquals("helenadantas", helena.getUsername());
		assertEquals("Noob", mariana.getTipo());
		assertEquals("Veterano", igor.getTipo());
		
		Jogo Pokemon = new RPG("Pokemon", 12.0);
		igor.addDinheiro(1000.0);
		igor.compraJogos(Pokemon);
		assertEquals(990.4, igor.getSaldo(), 0.05);
		igor.registraJogada("Pokemon", 200, false);
		assertEquals(1190, igor.getX2p());
		
		Jogo TheSims = new Plataforma("The Sims", 95.0);
		helena.addDinheiro(200.0);
		helena.compraJogos(TheSims);
		assertEquals(950, helena.getX2p());
		helena.registraJogada("The Sims", 456, true);
		assertEquals(970, helena.getX2p());
		
		Jogo GTA = new Luta("Grand Theft Auto", 0.0);
		mariana.addDinheiro(10.0);
		mariana.compraJogos(GTA);
		mariana.registraJogada("Grand Theft Auto", 5720, false);
		assertEquals(5, mariana.getX2p());
		
	}
	
	@Test
	public void testConstrutorWithException() {
		try {

			Usuario usuario = new Noob("  ", "BenardiMonitor");
			fail("Lancamento de Exception com nome do usuario vazio");

		} catch (Exception e) {

			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());

		}
		
		try {

			Usuario usuario = new Noob(null, "BenardiMonitor");
			fail("Lancamento de Exception com nome do usuario igual a null");

		} catch (Exception e) {

			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());

		}

		try {

			Usuario usuario = new Veterano("Benardi", " ");
			fail("Lancamento de Exception com login do usuario vazio");

		} catch (Exception e) {

			assertEquals("Username nao pode ser nulo ou vazio", e.getMessage());

		}
		
		try {

			Usuario usuario = new Veterano("Benardi", null);
			fail("Lancamento de Exception com login do usuario igual a null");

		} catch (Exception e) {

			assertEquals("Username nao pode ser nulo ou vazio", e.getMessage());

		}
		
		try {

			Usuario usuario = new Veterano("Benardi", "benardi");
			usuario.setSaldo(-10.5);
			fail("Lancamento de Exception quando o usuario tentar adicionar um valor negativo");

		} catch (Exception e) {

			assertEquals("Valor negativo nao eh permitido", e.getMessage());

		}
		
		
	}
	

}
