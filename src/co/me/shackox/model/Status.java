package co.me.shackox.model;

public class Status {

	private int status;
	private boolean error;
	private String message;

	public Status() {
		super();
	}

	public Status(int status, boolean error, String message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [status=" + status + ", error=" + error + ", message=" + message + "]";
	}

}
