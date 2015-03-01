package pos;

import java.util.Map;

public class PointOfSaleApp {

	private Display display;
	private final Map<String, String> productLine;

	public PointOfSaleApp(Display display, Map<String, String> productLine) {
		this.display = display;
		this.productLine = productLine;
	}

	public void onBarcode(String barcode) {
		String price = "N/A";
		if(barcode.isEmpty())
			price = "";
		if(productLine.containsKey(barcode)) 
			price = productLine.get(barcode);
		display.sendMessage(price);
	}
}
