package buycorp.specification.rest.api.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author kashyap.mishra
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/buycorp-specification-rest-api",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=BuycorpSpecificationRestApi"
	},
	service = Application.class
)
@Generated("")
public class BuycorpSpecificationRestApiApplication extends Application {
}