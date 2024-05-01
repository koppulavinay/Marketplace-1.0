package com.marketplace.category.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.marketplace.category.constants.CategoryViewPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(service = UserNotificationHandler.class)
public class SendNotificationToCategoryUserHandler extends BaseUserNotificationHandler{
	public static final String PORTLET_ID = "Category_Portlet";
	
	// create notification template
	public SendNotificationToCategoryUserHandler() {
		setPortletId(SendNotificationToCategoryUserHandler.PORTLET_ID);
	}
	
	// creating notification
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String notificationTitle=jsonObject.getString(CategoryViewPortletKeys.TITLE);
		String notificationSentBy=jsonObject.getString(CategoryViewPortletKeys.SENDER);
		String notificationcreateBy=jsonObject.getString(CategoryViewPortletKeys.CREATED);
		String notificationDetails = jsonObject.getString(CategoryViewPortletKeys.STATUS);
		String assetCategoryId = jsonObject.getString(CategoryViewPortletKeys.ASSET_CATEGORYID);
		String url = jsonObject.getString(CategoryViewPortletKeys.URL);
		String categoryId=jsonObject.getString(CategoryViewPortletKeys.CATEGORY_ID);
		return StringUtil.replace(getBodyTemplate(), 
				new String[] {"[$URL$]","[$CATEGORYID$]","[$ASSETCATEGORYID$]","[$USER$]","[$CREATED$]","[$TITLE$]", "[$BODY_TEXT$]" },
				new String[] {url,categoryId,assetCategoryId,notificationSentBy,notificationcreateBy,"<strong>" + notificationTitle + "</strong>", notificationDetails });
	}
	
	// notification link
	@Override
	protected String getLink(
		UserNotificationEvent userNotificationEvent,
		ServiceContext serviceContext) throws Exception {
		return super.getLink(userNotificationEvent, serviceContext);
	}

	// templete
	@Override
	protected String getBodyTemplate() throws Exception {
		return CategoryViewPortletKeys.NOTIFICATION_RETURN;
	}
	
	
}
