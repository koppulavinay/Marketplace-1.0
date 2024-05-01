package checkout.custom.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "message"
})

public class OMSCreateDraftOrderResponse implements Serializable {

	private static final long serialVersionUID = 8211528458248361852L;

	@SerializedName("data")
	private Data data;
	@SerializedName("message")
	private String message;

	@SerializedName("data")
	public Data getData() {
		return data;
	}

	@SerializedName("data")
	public void setData(Data data) {
		this.data = data;
	}

	@SerializedName("message")
	public String getMessage() {
		return message;
	}

	@SerializedName("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OMSResponse [data=" + data + ", message=" + message + "]";
	}

}
