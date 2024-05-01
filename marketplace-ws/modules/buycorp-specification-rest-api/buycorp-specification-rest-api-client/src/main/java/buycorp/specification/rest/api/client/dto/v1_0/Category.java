package buycorp.specification.rest.api.client.dto.v1_0;

import buycorp.specification.rest.api.client.function.UnsafeSupplier;
import buycorp.specification.rest.api.client.serdes.v1_0.CategorySerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author kashyap.mishra
 * @generated
 */
@Generated("")
public class Category implements Cloneable, Serializable {

	public static Category toDTO(String json) {
		return CategorySerDes.toDTO(json);
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryId(
		UnsafeSupplier<Long, Exception> categoryIdUnsafeSupplier) {

		try {
			categoryId = categoryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long categoryId;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCategoryName(
		UnsafeSupplier<String, Exception> categoryNameUnsafeSupplier) {

		try {
			categoryName = categoryNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String categoryName;

	public Boolean getIscategorymandatory() {
		return iscategorymandatory;
	}

	public void setIscategorymandatory(Boolean iscategorymandatory) {
		this.iscategorymandatory = iscategorymandatory;
	}

	public void setIscategorymandatory(
		UnsafeSupplier<Boolean, Exception> iscategorymandatoryUnsafeSupplier) {

		try {
			iscategorymandatory = iscategorymandatoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean iscategorymandatory;

	@Override
	public Category clone() throws CloneNotSupportedException {
		return (Category)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Category)) {
			return false;
		}

		Category category = (Category)object;

		return Objects.equals(toString(), category.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CategorySerDes.toJSON(this);
	}

}