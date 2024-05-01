package buycorp.specification.rest.api.client.dto.v1_0;

import buycorp.specification.rest.api.client.function.UnsafeSupplier;
import buycorp.specification.rest.api.client.serdes.v1_0.SpecificationValueSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author kashyap.mishra
 * @generated
 */
@Generated("")
public class SpecificationValue implements Cloneable, Serializable {

	public static SpecificationValue toDTO(String json) {
		return SpecificationValueSerDes.toDTO(json);
	}

	public String getSpecificationUOM() {
		return specificationUOM;
	}

	public void setSpecificationUOM(String specificationUOM) {
		this.specificationUOM = specificationUOM;
	}

	public void setSpecificationUOM(
		UnsafeSupplier<String, Exception> specificationUOMUnsafeSupplier) {

		try {
			specificationUOM = specificationUOMUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String specificationUOM;

	public Long getSpecificationValueId() {
		return specificationValueId;
	}

	public void setSpecificationValueId(Long specificationValueId) {
		this.specificationValueId = specificationValueId;
	}

	public void setSpecificationValueId(
		UnsafeSupplier<Long, Exception> specificationValueIdUnsafeSupplier) {

		try {
			specificationValueId = specificationValueIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long specificationValueId;

	public String getSpecificationValueLabel() {
		return specificationValueLabel;
	}

	public void setSpecificationValueLabel(String specificationValueLabel) {
		this.specificationValueLabel = specificationValueLabel;
	}

	public void setSpecificationValueLabel(
		UnsafeSupplier<String, Exception>
			specificationValueLabelUnsafeSupplier) {

		try {
			specificationValueLabel =
				specificationValueLabelUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String specificationValueLabel;

	@Override
	public SpecificationValue clone() throws CloneNotSupportedException {
		return (SpecificationValue)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecificationValue)) {
			return false;
		}

		SpecificationValue specificationValue = (SpecificationValue)object;

		return Objects.equals(toString(), specificationValue.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return SpecificationValueSerDes.toJSON(this);
	}

}