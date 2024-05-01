package com.marketplace.product.view.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.helper.SpecificationSelectionHelper;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name="
				+ ProductViewPortletKeys.GET_SPEC_VALUES_BY_SPEC_ID_RESOURCE_CMD, }, service = MVCResourceCommand.class)
public class GetSpecValuesBySpecIdResource implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		_log.info("---------------- Inside GetSpecificationValueResource ----------------");

		JSONObject requestBody = CommonUtil.getJsonFromRequestBody(resourceRequest);

		try {

			JSONObject specificationValuesJson = specificationSelectionHelper.getSpecValuesBySpecId(requestBody);

			CommonUtil.getPrintWriter(resourceResponse).write(specificationValuesJson.toString());

		} catch (PortalException e) {

			_log.warn("Unable to get Specification Values. Please enable debug logs for full details.");
			_log.debug(e, e);

		}

		return false;
	}

	@Reference
	private SpecificationSelectionHelper specificationSelectionHelper;

	private static final Log _log = LogFactoryUtil.getLog(GetSpecValuesBySpecIdResource.class);

}
