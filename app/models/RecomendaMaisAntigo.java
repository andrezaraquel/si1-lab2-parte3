package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendaMaisAntigo extends EstrategiaRecomendacao{

	public RecomendaMaisAntigo() {		
	}
	
	@Override
	public Episodio getProximoEpisodio(int temporada, Serie contexto) {
		List<Episodio> eps = contexto.getEpisodios(temporada);
		for (int i = 0; i < eps.size(); i++){			
			if(!eps.get(i).isAssistido()) {
				return eps.get(i);
			}			
		}
		return null;
	}

}
