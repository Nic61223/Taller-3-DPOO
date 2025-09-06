package uniandes.dpoo.aerolinea.modelo;

import java.util.HashMap;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private HashMap<String,Tiquete > tiquetes;
	
	
public Vuelo(Ruta ruta, Avion avion, String fecha ){
	this.ruta = ruta;
	this.avion = avion;
	this.fecha = fecha;
	this.tiquetes = new HashMap<String,Tiquete>();
	
}

public String getFecha() {
	return fecha;
}

public Avion getAvion() {
	return avion;
}

public Ruta getRuta() {
	return ruta;
}

public HashMap<String, Tiquete> getTiquetes() {
	return tiquetes;
}

public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException{
	if(cantidad > avion.getCapacidad()) {
		throw new VueloSobrevendidoException(this);
		
	}
	else {
		int valor = 0;
		for(int i= 0; i < cantidad+1; i++) {
			Tiquete nuevo = GeneradorTiquetes.generarTiquete(this, cliente, (int) calculadora.calcularTarifa(this, cliente));
			tiquetes.put(nuevo.getCodigo(), nuevo);
			GeneradorTiquetes.registrarTiquete(nuevo);
			cliente.agregarTiquete(nuevo);
			valor += nuevo.getTarifa();
			
		}
	return valor;
	}
}



public boolean equals(Object obj) {
    if (obj instanceof Vuelo) {
        Vuelo otro = (Vuelo) obj;
        return this.getRuta().equals(otro.getRuta()) && this.getFecha().equals(otro.getFecha());
    }
    return false;
}
	
}




	


