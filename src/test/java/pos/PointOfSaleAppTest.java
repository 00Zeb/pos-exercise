package pos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointOfSaleAppTest {

	// Test list
	// *. invalid ("") bar code, displays nothing ("")
	// *. bar code ("1234") is found , displays correct price ("$12.34"
	// *. invalid (null) bar code, displays nothing ("")
	// *. bar code ("9999") not found, displays price not found ("NOT FOUND)

	@Test
	public void empty_barcode_displays_nothing() {
		Display display = new Display();
		PointOfSaleApp pointOfSaleApp = new PointOfSaleApp(display);
		pointOfSaleApp.onBarcode("");
		assertEquals("", display.getLastMessage());
	}
}
