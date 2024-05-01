package buycorp.specification.rest.api.client.dto.v1_0;

import buycorp.specification.rest.api.client.dto.v1_0.Category;
import buycorp.specification.rest.api.client.dto.v1_0.SpecificationValue;
import buycorp.specification.rest.api.client.function.UnsafeSupplier;
import buycorp.specification.rest.api.client.serdes.v1_0.SpecificationUpdateObjectSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author kashyap.mishra
 * @generated
 */
@Generated("")
public class SpecificationUpdateObject implements Cloneable, Serializable {

	public static SpecificationUpdateObject toDTO(String json) {
		return SpecificationUpdateObjectSerDes.toDTO(json);
	}

	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	public void setCategories(
		UnsafeSupplier<Category[], Exception> categoriesUnsafeSupplier) {

		try {
			categories = categoriesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Category[] categories;

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedBy(
		UnsafeSupplier<Long, Exception> modifiedByUnsafeSupplier) {

		try {
			modifiedBy = modifiedByUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long modifiedBy;

	public String getSpecificationDescription() {
		return specificationDescription;
	}

	public void setSpecificationDescription(String specificationDescription) {
		this.specificationDescription = specificationDescription;
	}

	public void setSpecificationDescription(
		UnsafeSupplier<String, Exception>
			specificationDescriptionUnsafeSupplier) {

		try {
			specificationDescription =
				specificationDescriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String specificationDescription;

	public Long getSpecificationFieldDataType() {
		return specificationFieldDataType;
	}

	public void setSpecificationFieldDataType(Long specificationFieldDataType) {
		this.specificationFieldDataType = specificationFieldDataType;
	}

	public void setSpecificationFieldDataType(
		UnsafeSupplier<Long, Exception>
			specificationFieldDataTypeUnsafeSupplier) {

		try {
			specificationFieldDataType =
				specificationFieldDataTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long specificationFieldDataType;

	public Long getSpecificationFieldType() {
		return specificationFieldType;
	}

	public void setSpecificationFieldType(Long specificationFieldType) {
		this.specificationFieldType = specificationFieldType;
	}

	public void setSpecificationFieldType(
		UnsafeSupplier<Long, Exception> specificationFieldTypeUnsafeSupplier) {

		try {
			specificationFieldType = specificationFieldTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long specificationFieldType;

	public Long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(Long specificationId) {
		this.specificationId = specificationId;
	}

	public void setSpecificationId(
		UnsafeSupplier<Long, Exception> specificationIdUnsafeSupplier) {

		try {
			specificationId = specificationIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long specificationId;

	public String getSpecificationLabel() {
		return specificationLabel;
	}

	public void setSpecificationLabel(String specificationLabel) {
		this.specificationLabel = specificationLabel;
	}

	public void setSpecificationLabel(
		UnsafeSupplier<String, Exception> specificationLabelUnsafeSupplier) {

		try {
			specificationLabel = specificationLabelUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String specificationLabel;

	public SpecificationValue[] getSpecificationValues() {
		return specificationValues;
	}

	public void setSpecificationValues(
		SpecificationValue[] specificationValues) {

		this.specificationValues = specificationValues;
	}

	public void setSpecificationValues(
		UnsafeSupplier<SpecificationValue[], Exception>
			specificationValuesUnsafeSupplier) {

		try {
			specificationValues = specificationValuesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected SpecificationValue[] specificationValues;

	@Override
	public SpecificationUpdateObject clone() throws CloneNotSupportedException {
		return (SpecificationUpdateObject)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecificationUpdateObject)) {
			return false;
		}

		SpecificationUpdateObject specificationUpdateObject =
			(SpecificationUpdateObject)object;

		return Objects.equals(toString(), specificationUpdateObject.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return SpecificationUpdateObjectSerDes.toJSON(this);
	}

}