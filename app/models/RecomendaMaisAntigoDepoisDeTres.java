package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendaMaisAntigoDepoisDeTres extends EstrategiaRecomendacao {

	private static final int MAX_EPISODIOS_ASSISTIDOS = 3;
	
	public RecomendaMaisAntigoDepoisDeTres() {		
	}
	
	@Override
	public Episodio getProximoEpisodio(int temporada, Serie contexto) {
		List<Episodio> eps = contexto.getEpisodios(temporada);		
		int lastIndex = eps.size()-1;
		
		for (int i = 0; i <= lastIndex; i++){			
			if (!eps.get(i).isAssistido()){				
				if (i == lastIndex || (i != lastIndex && !possuiTresOuMaisAssistidos(eps.subList(i+1, lastIndex+1)))){	
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
			
			if (count >= MAX_EPISODIOS_ASSISTIDOS){
				
				return true;
			}
		}		
		return false;
	}

}
