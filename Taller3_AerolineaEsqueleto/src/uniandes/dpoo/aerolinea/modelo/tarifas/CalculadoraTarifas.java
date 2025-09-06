package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public final double IMPUESTO = 0.28;
	private Vuelo vuelo;
	private Cliente cliente;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		return (int) ((int) (calcularCostoBase(vuelo,cliente) + calcularValorImpuestos(calcularCostoBase(vuelo,cliente))*IMPUESTO)*(1+IMPUESTO));

	}

	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double PorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		return Aeropuerto.calcularDistancia(ruta.getDestino(), ruta.getOrigen());
				
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		return (int) (costoBase*IMPUESTO);
	}

}
