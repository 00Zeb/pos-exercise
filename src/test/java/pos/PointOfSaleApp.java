package pos;

public class PointOfSaleApp {

	private Display display;

	public PointOfSaleApp(Display display) {
		this.display = display;
	}

	public void onBarcode(String barcode) {
		display.sendMessage(barcode);
	}
}
