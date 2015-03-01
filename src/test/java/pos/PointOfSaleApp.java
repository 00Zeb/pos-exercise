package pos;

public class PointOfSaleApp {

	private Display display;

	public PointOfSaleApp(Display display) {
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
