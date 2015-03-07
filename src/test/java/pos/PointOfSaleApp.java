package pos;

import java.util.HashMap;
import java.util.Map;

public class PointOfSaleApp {

	private Display display;

	public PointOfSaleApp(Display display) {
		this.display = display;
	}

	public void onBarcode(String barcode) {
		@SuppressWarnings("serial")
		Map<String, String> productLine = new HashMap<String, String>() {
			{
				put("12345", "$7.95");
			}
		};
		display.sendMessage(productLine.getOrDefault(barcode, ""));
	}
}
