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
	

	public String getSpaYbienestar() {
		return spaYbienestar;
	}

	public void setSpaYbienestar(String spaYbienestar) {
		this.spaYbienestar = spaYbienestar;
	}

	public String getLavanderiaYtintoreria() {
		return lavanderiaYtintoreria;
	}

	public void setLavanderiaYtintoreria(String lavanderiaYtintoreria) {
		this.lavanderiaYtintoreria = lavanderiaYtintoreria;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

}
