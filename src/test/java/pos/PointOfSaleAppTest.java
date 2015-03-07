package pos;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

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
		@SuppressWarnings("serial")
		PointOfSaleApp pointOfSaleApp = new PointOfSaleApp(display, new HashMap<String, String>() {
			{
				put("12345", "$7.95");
			}
		});
		pointOfSaleApp.onBarcode("");
		assertEquals("", display.getLastMessage());
	}
	
	@Test
	public void finds_barcode_then_displays_price() {
		Display display = new Display();
		@SuppressWarnings("serial")
		PointOfSaleApp pointOfSaleApp = new PointOfSaleApp(display, new HashMap<String, String>() {
			{
				put("12345", "$7.95");
			}
		});
		pointOfSaleApp.onBarcode("12345");
		assertEquals("$7.95", display.getLastMessage());
	}
}
