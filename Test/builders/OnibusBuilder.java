package builders;

import java.util.ArrayList;
import java.util.Collection;

import enums.Disponibilidade;
import models.Acento;
import models.Onibus;

public class OnibusBuilder {
	
	private Onibus onibus;
	private Collection<Onibus> listOnibus;
	
	public static OnibusBuilder mockOnibus() {
		OnibusBuilder builder = new OnibusBuilder();
		builder.onibus = new Onibus("1", 20);
		
		return builder;
	}
	
	public static OnibusBuilder mockCollectionOnibus() {
		OnibusBuilder builder = new OnibusBuilder();
		builder.listOnibus = new ArrayList<Onibus>();
		
		for(int i=0; i<10 ; i++) {
			Onibus onibus = new Onibus("1"+i, i);
			
			builder.listOnibus.add(onibus);
		}
		
		return builder;
	}
	
	public Onibus getOnibus() {
		return this.onibus;
	}
	
	public Collection<Onibus> getListOnibus(){
		return this.listOnibus;
	}

}
