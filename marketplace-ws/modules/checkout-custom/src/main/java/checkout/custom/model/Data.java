package checkout.custom.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rediect_url",
    "status"
})

public class Data implements Serializable {

	private static final long serialVersionUID = 4134616594869362432L;

	@SerializedName("rediect_url")
	private String rediectUrl;
	@SerializedName("status")
	private String status;

	@SerializedName("rediect_url")
	public String getRediectUrl() {
		return rediectUrl;
	}

	@SerializedName("rediect_url")
	public void setRediectUrl(String rediectUrl) {
		this.rediectUrl = rediectUrl;
	}

	@SerializedName("status")
	public String getStatus() {
		return status;
	}

	@SerializedName("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Data [rediectUrl=" + rediectUrl + ", status=" + status + "]";
	}

}
