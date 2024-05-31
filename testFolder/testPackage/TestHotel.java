package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesHotel.Hotel;

public class TestHotel {

	private Hotel hotel = new Hotel("El Sueño");
	@Test
	public void queExistaUnHotel() {
	assertNotNull(this.hotel);
	}

}
