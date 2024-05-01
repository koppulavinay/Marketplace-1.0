package checkout.custom.model;

import com.google.gson.annotations.SerializedName;


public class BIDResponse {

	@SerializedName("status")
	String status;

	@SerializedName("message")
	String message;

	@SerializedName("data")
	BidData data;


	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setData(BidData data) {
		this.data = data;
	}
	public BidData getData() {
		return data;
	}

}