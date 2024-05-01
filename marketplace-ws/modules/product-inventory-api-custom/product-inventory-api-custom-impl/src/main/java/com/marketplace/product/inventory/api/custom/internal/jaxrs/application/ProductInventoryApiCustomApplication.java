package com.marketplace.product.inventory.api.custom.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author ashishinani
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/product-inventory-api-custom",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=ProductInventoryApiCustom"
	},
	service = Application.class
)
@Generated("")
public class ProductInventoryApiCustomApplication extends Application {
}