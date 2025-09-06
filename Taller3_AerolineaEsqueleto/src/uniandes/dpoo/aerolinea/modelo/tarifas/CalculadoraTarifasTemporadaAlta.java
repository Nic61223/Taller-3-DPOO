package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	protected final int COSTO_POR_KM = 100;
	
	public CalculadoraTarifasTemporadaAlta() {}
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		return super.calcularDistanciaVuelo(vuelo.getRuta())*COSTO_POR_KM;
	}

	@Override
	protected double PorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0.0;
	}

}
