/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.marketplace.product.mediasku.master.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ProductMediaSKU service. Represents a row in the &quot;marketplace_product_mediasku&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKUModel
 * @generated
 */
@ImplementationClassName(
	"com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUImpl"
)
@ProviderType
public interface ProductMediaSKU extends PersistedModel, ProductMediaSKUModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProductMediaSKU, Long>
		PRODUCT_MEDIA_SKU_ID_ACCESSOR = new Accessor<ProductMediaSKU, Long>() {

			@Override
			public Long get(ProductMediaSKU productMediaSKU) {
				return productMediaSKU.getProductMediaSKUId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProductMediaSKU> getTypeClass() {
				return ProductMediaSKU.class;
			}

		};

}