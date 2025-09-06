package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete  {
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente clienteComprador;

	
public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador,int tarifa  ) {
	this.codigo = codigo;
	this.tarifa = tarifa ;
	this.usado = false;
	this.vuelo = vuelo;
	this.clienteComprador = clienteComprador;
	
}



public String getCodigo() {
	return codigo;
}



public int getTarifa() {
	return tarifa;
}



public Vuelo getVuelo() {
	return vuelo;
}



public Object getClienteComprador() {
	return clienteComprador;
}

public void marcarComoUsado() {
	setUsado(true);
}



public void setUsado(boolean usado) {
	this.usado = usado;
}

public boolean esUsado()
{return isUsado();
	}



public boolean isUsado() {
	return usado;
}
}
