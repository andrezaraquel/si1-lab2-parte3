import static org.junit.Assert.*;

import models.RecomendaMaisAntigoDepoisDeTres;
import models.Serie;

import org.junit.Test;

public class RecomendaMaisAntigoDepoisDeTresTest {

	@Test
	public void deveRetornarEpisodioCerto() {
		Serie serie = new Serie("serie A");
		serie.addEpisodio("Episodio 1", 1, 3);
		serie.addEpisodio("Episodio 2", 2, 3);
		serie.addEpisodio("Episodio 3", 3, 3);
		serie.addEpisodio("Episodio 4", 4, 3);
		serie.addEpisodio("Episodio 5", 5, 3);
		
		assertTrue(serie.ehEstrategiaDefault());		
		serie.setEstrategia(new RecomendaMaisAntigoDepoisDeTres());
		assertTrue(serie.ehEstrategiaMaisAntigaDepoisDeTres());
		
				
		serie.getEpisodios(3).get(1).mudaStatus();
		serie.getEpisodios(3).get(2).mudaStatus();

		assertEquals(serie.getProximoEpisodio(3), serie.getEpisodios(3).get(0));
		serie.getEpisodios(3).get(3).mudaStatus();
		assertEquals(serie.getProximoEpisodio(3), serie.getEpisodios(3).get(4));
		
	}

}
