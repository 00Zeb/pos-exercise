package pos;

import java.util.Map;

public class PointOfSaleApp {
	private final Display display;
	private final Map<String, String> productLine;

	public PointOfSaleApp(Display display, Map<String, String> productLine) {
		this.display = display;
		this.productLine = productLine;
	}

	public void onBarcode(String barcode) {
		display.sendMessage(productLine.getOrDefault(barcode, ""));
	}
}
