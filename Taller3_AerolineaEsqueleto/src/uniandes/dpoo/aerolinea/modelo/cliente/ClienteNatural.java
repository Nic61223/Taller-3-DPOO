package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class ClienteNatural extends Cliente {
    public static String NATURAL = "Natural";
    private String nombre;

    public ClienteNatural(String nombre) {
        super();
        this.nombre = nombre;
    }

    @Override
    public String getIdentificador() {
        return nombre;
    }

    @Override
    public String getTipoCliente() {
        return NATURAL;
    }

	

	@Override
	public void agregarTiquete(Tiquete tiquete) {
		// TODO Auto-generated method stub
		if(tiquete.isUsado()) {
			listaUsados.add(tiquete);
		}
		else {
			listaNoUsados.add(tiquete);
		}}


}



