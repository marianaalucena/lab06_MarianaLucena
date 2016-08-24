package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.RPG;
import Loja.Fachada;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class TesteFachada {

	private Jogo Pokemon;
	private Jogo TheSims;
	private Jogo GTA;

	private Usuario rafa;
	private Usuario igor;
	private Usuario helena;

	private Fachada fachada;

	@Before
	public void setUp() throws Exception {
		rafa = new Noob("RafaelChagas", "rafael");
		igor = new Veterano("Igor Lucena", "igorlucena");
		helena = new Noob("Helena Dantas", "helenadantas");

		Pokemon = new RPG("Pokemon", 5.0);
		TheSims = new Plataforma("The Sims", 60.0);
		GTA = new Luta("Grand Theft Auto", 100.0);

		fachada = new Fachada();

	}

	@Test
	public void testFachada() throws Exception {
		fachada.addUsuario(rafa);
		fachada.addUsuario(igor);
		fachada.getUsuarios();

		assertEquals(rafa, fachada.buscaUsuario("rafael"));
		assertTrue(fachada.removeUsuario("igorlucena"));
		assertTrue(fachada.addDinheiro("rafael", 150.0));

		fachada.vendeJogo("rafael", GTA);

		assertEquals(60.0, rafa.getSaldo(), 0.05);
		rafa.registraJogada("Pokemon", 10000, false);

		assertTrue(fachada.upgrade("rafael"));
		
		rafa = fachada.buscaUsuario("rafael");
		
		System.out.println(rafa.getTipo());

		assertTrue(rafa instanceof Veterano);

	}
}
