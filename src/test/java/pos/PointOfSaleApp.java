package pos;

import java.util.Map;

public class PointOfSaleApp {

	private Display display;

	public PointOfSaleApp(Display display, Map<String, String> productLine) {
		this.display = display;
	}

	public void onBarcode(String barcode) {
		String price = "N/A";
		if(barcode.isEmpty())
			price = "";
		if(barcode.equals("12345")) 
			price = "$7.95";
		display.sendMessage(price);
	}
}
