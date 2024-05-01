package com.marketplace.brand.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.marketplace.brand.constants.BrandViewPortletKeys;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

// notification template and create notification 
@Component(service = UserNotificationHandler.class)
public class SendNotificationToUserHandler extends BaseUserNotificationHandler{
	public static final String PORTLET_ID = "Brand_Portlet";

	public SendNotificationToUserHandler() {

	setPortletId(SendNotificationToUserHandler.PORTLET_ID);

	}
	// creating notification
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String notificationTitle = jsonObject.getString(BrandViewPortletKeys.TITLE);
		String notificationSentBy = jsonObject.getString(BrandViewPortletKeys.SENDER);
		String notificationcreateBy = jsonObject.getString(BrandViewPortletKeys.CREATED);
		String notificationDetails = jsonObject.getString(BrandViewPortletKeys.STATUS);
		String brandId = jsonObject.getString(BrandViewPortletKeys.BRAND_ID);
		String url = jsonObject.getString(BrandViewPortletKeys.URL);
		return StringUtil.replace(getBodyTemplate(), 
				new String[] {"[$URL$]", "[$BRANDID$]","[$USER$]","[$CREATED$]","[$TITLE$]", "[$BODY_TEXT$]" },
				new String[] {url, brandId, notificationSentBy, notificationcreateBy, "<strong>" + notificationTitle + "</strong>", notificationDetails});
	}
	
	//setting up notificationevent
	@Override
	protected String getLink(
		UserNotificationEvent userNotificationEvent,
		ServiceContext serviceContext) throws Exception {
		return super.getLink(userNotificationEvent, serviceContext);
	}
	// template
	@Override
	protected String getBodyTemplate() throws Exception {
		return BrandViewPortletKeys.NOTIFICATION_RETURN;
	}
	
	//send notifications
	protected static void sendNotification(User user, JSONObject payload){
		SendNotificationToUserHandler hndlr = new SendNotificationToUserHandler();
		
		if(UserNotificationManagerUtil.fetchUserNotificationDefinition(hndlr.getPortletId(),
				ClassNameLocalServiceUtil.getClassNameId(hndlr.getClass().getName()),
				UserNotificationDeliveryConstants.TYPE_WEBSITE) == null) {

			    UserNotificationDefinition def = new UserNotificationDefinition(hndlr.getPortletId(),
						ClassNameLocalServiceUtil.getClassNameId(hndlr.getClass().getName()), 0, "");
			    def.addUserNotificationDeliveryType(new UserNotificationDeliveryType("Website",
					    UserNotificationDeliveryConstants.TYPE_WEBSITE, true, true));
			}

		UserNotificationEvent notification = UserNotificationEventLocalServiceUtil
				.createUserNotificationEvent(CounterLocalServiceUtil.increment());
		notification.setCompanyId(user.getCompanyId());
		notification.setUserId(user.getUserId());
		notification.setPayload(payload.toString());
		notification.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
		notification.setTimestamp(new Date().getTime());
		notification.setArchived(false);
		notification.setDelivered(true);
		notification.setType(hndlr.getPortletId());
		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(notification);
	}
}
