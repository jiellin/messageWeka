package data;

public class Message {
	private String content;
	private String isOK;
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		
		this.content = content;
	}
	
	public String getIsOK() {
		return this.isOK;
	}
	
	public void setIsOK(String isOK) {
		this.isOK = isOK;
	}
	
	public Message fillMessage(String content, String isOK) {
		Message message = new Message();
		message.setContent(content);
		message.setIsOK(isOK);
		return message;
	}

}
