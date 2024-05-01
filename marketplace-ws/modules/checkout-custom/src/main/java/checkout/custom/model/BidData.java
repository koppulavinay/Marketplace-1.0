package checkout.custom.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"rediect_url",
		"status",
		"bc_id",
		"cart_id"
})

public class BidData implements Serializable {

	private static final long serialVersionUID = 4134616594869362432L;

	@SerializedName("rediect_url")
	private String rediectUrl;
	@SerializedName("status")
	private String status;

	@SerializedName("bc_id")
	private Long bcId;

	@SerializedName("cart_id")
	private Long cartId;


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

	public Long getBcId() {
		return bcId;
	}

	public void setBcId(Long bcId) {
		this.bcId = bcId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "BidData [rediectUrl=" + rediectUrl + ", status=" + status + ", bcId=" + bcId + ", cartId=" + cartId
				+ "]";
	}



}
