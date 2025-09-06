package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected  final double DESCUENTO_GRANDES = 0.2;
	
	public CalculadoraTarifasTemporadaBaja() {
		
	}
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		int dist =super.calcularDistanciaVuelo(vuelo.getRuta());
		if (cliente.getTipoCliente().equals("corporativo")){
			return dist*COSTO_POR_KM_CORPORATIVO;
		}
		else {
			return dist* COSTO_POR_KM_NATURAL;
		}
	}

	@Override
	protected double PorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		if (cliente.getTipoCliente().equals("corporativo")){
			if (((ClienteCorporativo) cliente).getTamanoEmpresa()==1) {
				return DESCUENTO_GRANDES;
			}
			else if (((ClienteCorporativo) cliente).getTamanoEmpresa()==2) {
				return DESCUENTO_MEDIANAS;
				
			}
			else {
				return DESCUENTO_PEQ;
			}
				
			}
		
		else {
			return 0.0;
			
		}
		}
	}
	

