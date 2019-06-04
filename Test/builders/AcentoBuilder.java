package builders;

import java.util.ArrayList;
import java.util.Collection;

import enums.Disponibilidade;
import models.Acento;

public class AcentoBuilder {
	
	private Acento acento;
	private Collection<Acento> acentos;
	
	public static AcentoBuilder mockAcento() {
		AcentoBuilder builder = new AcentoBuilder();
		builder.acento = new Acento(Disponibilidade.DISPONIVEL, 10);
		
		return builder;
	}
	
	public static AcentoBuilder mockCollectionAcentos() {
		AcentoBuilder builder = new AcentoBuilder();
		builder.acentos = new ArrayList<Acento>();
		
		for(int i=0; i<10 ; i++) {
			Acento acento = new Acento(Disponibilidade.DISPONIVEL, i);
			
			builder.acentos.add(acento);
		}
		
		return builder;
	}
	
	public Acento getAcento() {
		return this.acento;
	}
	
	public Collection<Acento> getAcentos(){
		return this.acentos;
	}
}
