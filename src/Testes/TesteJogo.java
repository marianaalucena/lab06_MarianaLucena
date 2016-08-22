package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.RPG;

public class TesteJogo {
	
	Jogo Pokemon;
	Jogo TheSims;
	Jogo GTA;
	
	@Before
	public void setUp() throws Exception {
		Pokemon = new RPG("Pokemon", 0.0);
		TheSims = new Plataforma("The Sims", 60.0);
		GTA = new Luta("Grand Theft Auto", 140.0);
		
	}
	

	@Test
	public void testJogoLuta(){
		assertEquals("Grand Theft Auto", GTA.getNome());
		assertEquals(30, GTA.registraJogadas(30659, false));
		assertEquals(140.0, GTA.getPreco(),0.05);
		assertEquals(30659, GTA.getMaiorScore());
		assertEquals(10, GTA.registraJogadas(10000, false));
		assertEquals(30659, GTA.getMaiorScore());
		}
	
	@Test
	public void testJogoPlataforma(){
		assertEquals("The Sims", TheSims.getNome());
		assertEquals(0, TheSims.registraJogadas(1239, false));
		assertEquals(60.0, TheSims.getPreco(),0.05);
		assertEquals(1239, TheSims.getMaiorScore());
		assertEquals(20, TheSims.registraJogadas(100, true));
		assertEquals(1239, TheSims.getMaiorScore());
		assertEquals(20, TheSims.registraJogadas(5042, true));
		assertEquals(5042, TheSims.getMaiorScore());
		}
	
	@Test
	public void testJogoRPG(){
		assertEquals("Pokemon", Pokemon.getNome());
		assertEquals(10, Pokemon.registraJogadas(652, false));
		assertEquals(0.0, Pokemon.getPreco(),0.05);
		assertEquals(652, Pokemon.getMaiorScore());
		assertEquals(10, Pokemon.registraJogadas(520, true));
		assertEquals(652, Pokemon.getMaiorScore());
		assertEquals(10, Pokemon.registraJogadas(5362, true));
		assertEquals(5362, Pokemon.getMaiorScore());
		}
}
