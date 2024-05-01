package com.marketplace.brand.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.marketplace.brand.constants.BrandConstants;
import com.marketplace.brand.model.Brand;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class BrandModelPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, Brand brand, String actionId) throws PortalException {

        return _brandModelResourcePermission.contains(permissionChecker, brand, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long brandId, String actionId) throws PortalException {

        return _brandModelResourcePermission.contains(permissionChecker, brandId, actionId);
    }

    @Reference(
            target = "(model.class.name=" + BrandConstants.RESOURCE_NAME_MODEL + ")", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Brand> modelResourcePermission) {

    	_brandModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Brand>_brandModelResourcePermission;

}