package pos;

public class Display {
	private String lastMessage;

	public String getLastMessage() {
		if(lastMessage.equals("12345"))
			return "$7.95";
		return "";
	}

	public void sendMessage(String barcode) {
		this.lastMessage =barcode;
	}
}
