package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendaProximoNaoAssistido extends EstrategiaRecomendacao{

	public RecomendaProximoNaoAssistido() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Episodio getProximoEpisodio(int temporada, Serie contexto) {
		List<Episodio> eps = contexto.getEpisodios(temporada);
		int i = 0;
		int index = -1; // indice do ultimo assistido
		while (i < eps.size()) {
			if(eps.get(i).isAssistido()) {
				index = i;
			}
			i++;
		}
		if(index == i-1){
			return null;
		}
		if(index == -1) {
			return eps.get(0);
		}
		return eps.get(index+1);
	}

	
	
}
