package buycorp.arx.process.filter.portlet;

import buycorp.arx.process.filter.constants.BuycorpArxProcessFilterPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author kashyap.mishra
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=buycorp",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BuycorpArxProcessFilter",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BuycorpArxProcessFilterPortletKeys.BUYCORPARXPROCESSFILTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BuycorpArxProcessFilterPortlet extends MVCPortlet {
}