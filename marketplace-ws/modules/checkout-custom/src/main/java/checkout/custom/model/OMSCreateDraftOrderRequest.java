package checkout.custom.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "token",
    "payload"
})


public class OMSCreateDraftOrderRequest implements Serializable {

	private static final long serialVersionUID = -954977641665515893L;

	@SerializedName("token")
	private String token;
	@SerializedName("payload")
	private CartV2 payload;

	@SerializedName("token")
	public String getToken() {
		return token;
	}

	@SerializedName("token")
	public void setToken(String token) {
		this.token = token;
	}

	public CartV2 getPayload() {
		return payload;
	}

	public void setPayload(CartV2 payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "OMSRequest [token=" + token + ", payload=" + payload + "]";
	}
}
