package gpschallenge;

public class Regla {
	
	EstadoVehiculo estado;
	EstadoVehiculo nuevoestado;
	EstadoVehiculo auto = Auto.getInstancia();
	EstadoVehiculo moto = Moto.getInstancia();
	EstadoVehiculo cuatroxcuatro = CuatroXCuatro.getInstancia();
	
	public EstadoVehiculo obtenernuevoestado (Vehiculo vehiculo) {
			
		estado = vehiculo.getEstado();
		
		if (estado == auto) {
			nuevoestado = CuatroXCuatro.getInstancia(); 
		}
		else {
			if (estado == moto){
				nuevoestado = Auto.getInstancia();
			}
			else {
				nuevoestado = CuatroXCuatro.getInstancia();
			}
		}
		
		return nuevoestado;
		
	}

}
