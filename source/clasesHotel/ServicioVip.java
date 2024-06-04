package clasesHotel;

public class ServicioVip extends Servicio {
	
	private String spaYbienestar;
	private String lavanderiaYtintoreria;
	private String transporte;

	public ServicioVip(String recreacion, String alimento, String limpieza, String spaYbienestar, String lavanderiaYTintoreria, String transporte) {
		super(recreacion, alimento, limpieza);
		this.spaYbienestar = spaYbienestar;
		this.lavanderiaYtintoreria = lavanderiaYTintoreria;
		this.transporte = transporte;
	}

}
