package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.HashSet;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	protected HashSet<Tiquete> listaNoUsados;
	protected HashSet<Tiquete> listaUsados;
	
	


public Cliente() {
	this.listaNoUsados = new HashSet<>();
	this.listaUsados = new HashSet<>();
	
	
}


public abstract String getTipoCliente();
public abstract String getIdentificador();
public abstract void agregarTiquete(Tiquete tiquete);


public int calcularValorTotalTiquetes(){
    int total = 0;
   
        for (Tiquete tiquete : listaUsados) {
            if (tiquete != null)
                total += tiquete.getTarifa();
            else
                total += 0;
        }
        
        for (Tiquete tiquete : listaNoUsados) {
            if (tiquete != null)
                total += tiquete.getTarifa();
            else
                total += 0;
        }
        
        
 
    return total;
}
public void usarTiquete(Vuelo vuelo) {
	
	for (Tiquete tiquete : listaNoUsados) {
    if (tiquete != null && !tiquete.esUsado() && tiquete.getVuelo().equals(vuelo)) {
        tiquete.marcarComoUsado();
        listaNoUsados.remove(tiquete);
    }

	}}
}
