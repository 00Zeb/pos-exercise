package pos;

import java.util.Map;

public class PointOfSaleApp {
	private final Display display;
	private final Map<String, String> productLine;
	private String missingBarcodeMessage;

	public PointOfSaleApp(Display display, Map<String, String> productLine, String missingBarcodeMessage) {
		this.display = display;
		this.productLine = productLine;
		this.missingBarcodeMessage = missingBarcodeMessage;
	}

	public void onBarcode(String barcode) {
		
		display.sendMessage(productLine.getOrDefault(barcode, missingBarcodeMessage));
	}
}
