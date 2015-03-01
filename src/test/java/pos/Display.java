package pos;

public class Display {
	private String lastMessage;

	public String getLastMessage() {
		return lastMessage;
	}

	public void sendMessage(String barcode) {
		this.lastMessage =barcode;
	}
}
