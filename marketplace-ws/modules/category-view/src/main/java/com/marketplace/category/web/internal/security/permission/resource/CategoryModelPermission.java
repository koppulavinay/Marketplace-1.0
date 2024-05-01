package com.marketplace.category.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.marketplace.category.constants.CategoryConstants;
import com.marketplace.category.model.Category;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class CategoryModelPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, Category category, String actionId) throws PortalException {
    	
        return _categoryModelResourcePermission.contains(permissionChecker, category, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long categoryId, String actionId) throws PortalException {

        return _categoryModelResourcePermission.contains(permissionChecker, categoryId, actionId);
    }

    @Reference(
            target = "(model.class.name=" + CategoryConstants.RESOURCE_NAME_MODEL + ")", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Category> modelResourcePermission) {

    	_categoryModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Category>_categoryModelResourcePermission;

}