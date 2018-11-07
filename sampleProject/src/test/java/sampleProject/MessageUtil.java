package sampleProject;

public class MessageUtil {

	private String message;

	public MessageUtil(String message) {
		this.message = message;
	}

	public Object printMessage() {
		System.out.println(message);
		return message;
	}

	public Object salutationMessage() {
		String me1 = "Hi!" + message;
		return me1;
	}

}
