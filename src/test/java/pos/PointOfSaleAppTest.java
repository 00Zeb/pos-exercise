package pos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PointOfSaleAppTest {

	// Test list
	// *. invalid ("") bar code, displays nothing ("")
	// *. bar code ("12345") is found , displays correct price ("$7.95").
	// *. bar code ("9999") not found, displays price not found ("NOT FOUND).
	// *. invalid (null) bar code, displays nothing ("")

	private Display display;
	private PointOfSaleApp pointOfSaleApp;

	@Before
	public void createApp() {
		display = new Display();
		pointOfSaleApp = new PointOfSaleApp(display);
	}

	@Test
	public void empty_barcode_displays_nothing() {
		pointOfSaleApp.onBarcode("");
		assertEquals("", display.getLastMessage());
	}

	@Test
	public void finds_barcode_then_displays_price() {
		pointOfSaleApp.onBarcode("12345");
		assertEquals("$7.95", display.getLastMessage());
	}
	
	@Test
	public void barcode_not_found_displays_price_not_found() {
		pointOfSaleApp.onBarcode("12346");
		assertEquals("N/A", display.getLastMessage());
	}
}
