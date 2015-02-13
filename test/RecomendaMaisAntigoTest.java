

import static org.junit.Assert.*;

import models.RecomendaMaisAntigo;
import models.Serie;

import org.junit.Before;
import org.junit.Test;

public class RecomendaMaisAntigoTest {

private Serie serie1;
	
	@Before
	public void criaObjetos(){
		 serie1 = new Serie("Serie1");
	}
	
	@Test
	public void deveRetornarEpisodioCerto(){
	
		serie1.addEpisodio("Episodio 1", 1, 3);
		serie1.addEpisodio("Episodio 2", 2, 3);
		serie1.addEpisodio("Episodio 3", 3, 3);
		serie1.addEpisodio("Episodio 4", 4, 3);
		serie1.addEpisodio("Episodio 5", 5, 3);
		
		assertTrue(serie1.ehEstrategiaDefault());		
		serie1.setEstrategia(new RecomendaMaisAntigo());
		assertTrue(serie1.ehEstrategiaMaisAntigo());
		
				
		serie1.getEpisodios(3).get(1).mudaStatus();
		serie1.getEpisodios(3).get(2).mudaStatus();

		assertEquals(serie1.getProximoEpisodio(3), serie1.getEpisodios(3).get(0));
		serie1.getEpisodios(3).get(3).mudaStatus();
		assertEquals(serie1.getProximoEpisodio(3), serie1.getEpisodios(3).get(0));
		serie1.getEpisodios(3).get(0).mudaStatus();
		assertEquals(serie1.getProximoEpisodio(3), serie1.getEpisodios(3).get(4));
	}

}
