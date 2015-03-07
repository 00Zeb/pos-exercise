package pos;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class PointOfSaleAppTest {

	private static final String MISSING_BARCODE_MESSAGE = "Scanning error";
	private static final String BARCODE_1 = "12345";
	private static final String BARCODE_2 = "12344";
	private static final String EMPTY_BARCODE = "";
	private Display display;
	private PointOfSaleApp pointOfSaleApp;

	// Test list
	// *. invalid ("") bar code, displays nothing ("")
	// *. bar code ("1234") is found , displays correct price ("$12.34"
	// *. invalid (null) bar code, displays nothing ("")
	// *. bar code ("9999") not found, displays price not found ("NOT FOUND)

	@Before
	@SuppressWarnings("serial")
	public void createApp() {
		display = new Display();
		pointOfSaleApp = new PointOfSaleApp(display, new HashMap<String, String>() {
			{
				put("", "");
				put(null, "");
				put(BARCODE_1, "$7.95");
				put(BARCODE_2, "$6.95");
			}
		}, MISSING_BARCODE_MESSAGE);
	}

	@Test
	public void empty_barcode_displays_nothing() {
		pointOfSaleApp.onBarcode("");
		assertEquals("", display.getLastMessage());
	}

	@Test
	public void invalid_barcode_displays_nothing() {
		pointOfSaleApp.onBarcode(null);
		assertEquals(EMPTY_BARCODE, display.getLastMessage());
	}

	@Test
	public void finds_barcode_then_displays_price() {
		pointOfSaleApp.onBarcode(BARCODE_1);
		assertEquals("$7.95", display.getLastMessage());
		pointOfSaleApp.onBarcode(BARCODE_2);
		assertEquals("$6.95", display.getLastMessage());
	}

	@Test
	public void barcode_not_found_displays_price_not_found() {
		String missingBarcode = "12346";
		pointOfSaleApp.onBarcode(missingBarcode);
		assertEquals(MISSING_BARCODE_MESSAGE, display.getLastMessage());
	}
}
