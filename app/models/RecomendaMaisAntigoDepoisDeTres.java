package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendaMaisAntigoDepoisDeTres extends EstrategiaRecomendacao {

	public RecomendaMaisAntigoDepoisDeTres() {		
	}
	
	@Override
	public Episodio getProximoEpisodio(int temporada, Serie contexto) {
		List<Episodio> eps = contexto.getEpisodios(temporada);
		int lastIndex = eps.size()-1;
		for (int i = 0; i <= lastIndex; i++){		
			if (!eps.get(i).isAssistido()){
				if(i != lastIndex && !possuiTresOuMaisAssistidos(eps.subList(i+1, -1))){
					return eps.get(i);
				}				
			}
		}
		return null;
	}

	private boolean possuiTresOuMaisAssistidos(List<Episodio> subListEpisodios) {
		int count = 0;
		for (int i = 0; i < subListEpisodios.size(); i++) {
			if (subListEpisodios.get(i).isAssistido()){
				count++;				
			}
			
			if (count >= 3){
				return true;
			}
		}		
		return false;
	}

}
