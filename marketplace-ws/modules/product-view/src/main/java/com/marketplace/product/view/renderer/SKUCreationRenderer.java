package com.marketplace.product.view.renderer;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.service.ProductVariantLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.handler.SKUMediaHandler;
import com.marketplace.product.view.helper.ProductSkuBean;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.service.VariantValueLocalService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name=skuCreationRender" }, service = MVCRenderCommand.class)

public class SKUCreationRenderer implements MVCRenderCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(SKUCreationRenderer.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SKUCreationRenderer Method"
				+ ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		String draftProductId = ParamUtil.getString(renderRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Long sellerId=themeDisplay.getUserId();
		LOGGER.info("draftProductId--> " + draftProductId);
		List<ProductSKU> productSkuLst = new ArrayList<>();
		HttpServletRequest servletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		HttpSession httpSession = servletRequest.getSession();
		String sessionskuName=(String) httpSession.getAttribute("sessionskuName");
		try {
			//productSkuLst = productSkuLocalService.findByDraftProductSkuId(Long.parseLong(draftProductId));
			LOGGER.info("productSkuLst size:" + productSkuLst.size());
			getSaveSkuPermutationVariant(draftProductId, sellerId,productSkuLocalService,productMediaSKULocalService,sessionskuName);
			productSkuLst = productSkuLocalService.findByDraftProductSkuId(Long.parseLong(draftProductId));
			
			LOGGER.info("productSkuLst size:" + productSkuLst.size());
			/*
			 * if (productSkuLst != null && productSkuLst.size() > 0) { productSkuLst =
			 * productSkuLocalService.findByDraftProductSkuId(Long.parseLong(draftProductId)
			 * ); } else { getSaveSkuPermutationVariant(draftProductId, sellerId);
			 * productSkuLst =
			 * productSkuLocalService.findByDraftProductSkuId(Long.parseLong(draftProductId)
			 * ); }
			 */
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		List<ProductSkuBean> productskuBeanLst = new ArrayList<>();
		List<ProductMediaSKU> productMediaSKUs = new ArrayList<>();
		for (ProductSKU productSKU : productSkuLst) {
			ProductSkuBean productSkuBean = new ProductSkuBean();
			productSkuBean.setSkuName(productSKU.getSkuName());
			productSkuBean.setStock(productSKU.getStock());
			productSkuBean.setBasePrice(productSKU.getBasePrice());
			productSkuBean.setCost(productSKU.getCost());
			productSkuBean.setDefaultSku(productSKU.getDefaultSku());
			productSkuBean.setDraftProductId(productSKU.getDraftProductId());
			productSkuBean.setLowStockThreshold(productSKU.getLowStockThreshold());
			productSkuBean.setMargin(productSKU.getMargin());
			productSkuBean.setMaximumOrderQuantity(productSKU.getMaximumOrderQuantity());
			productSkuBean.setMinimumOrderQuantity(productSKU.getMinimumOrderQuantity());
			productSkuBean.setOfferPrice(productSKU.getOfferPrice());
			productSkuBean.setProductSKUId(productSKU.getProductSKUId());
			productSkuBean.setSellerSkuId(productSKU.getSellerSkuId());
			productSkuBean.setSkuExpiryDate(productSKU.getSkuExpiryDate());
			productSkuBean.setSkuId(productSKU.getSkuId());
			productSkuBean.setSkuPublishingDate(productSKU.getSkuPublishingDate());
			productSkuBean.setTax(productSKU.getTax());
			productSkuBean.setUom(productSKU.getUom());
			productSkuBean.setSkuCreationName(productSKU.getSkuCreationName().replaceAll("/", "-"));
			//productSkuBean.setSkuCreationName(productSkuBean.getSkuCreationName().replaceAll(" ", "_"));
			
			productMediaSKUs = productMediaSKULocalService.findByProductSKUIdWithDraftProductId(productSKU.getDraftProductId(), productSKU.getProductSKUId());
			 
			LOGGER.info("--------------------------------------------->" + productMediaSKUs.size());
			productSkuBean.setProductMediaSkuLst(productMediaSKUs);
			//productSkuBean.setCpTaxCategoryLst(cptaxCategoryLst);
			productskuBeanLst.add(productSkuBean);
		}
		
		renderRequest.setAttribute(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
		renderRequest.setAttribute("variantPermutations", productskuBeanLst);
		return ProductViewPortletKeys.SKU_CREATION_JSP;
	}

	public void getSaveSkuPermutationVariant(String draftProductId, Long sellerId,
			ProductSKULocalService productSkuLocalService, ProductMediaSKULocalService productMediaSKULocalService,
			String sessionskuName) throws PortalException {

		List<ProductSKU> addSkuLst = new ArrayList<>();
		List<ProductVariant> productVariantLst = productVariantLocalService
				.findByDraftProductId(Long.parseLong(draftProductId));
		ArrayList<String[]> mainArrayList = new ArrayList<String[]>();
		ArrayList<String> subArrayList;
		for (Iterator<ProductVariant> iterator = productVariantLst.iterator(); iterator.hasNext();) {
			ProductVariant productVariant = (ProductVariant) iterator.next();
			List<VariantValue> variantValueLst = variantValueLocalService
					.findByProductVariantId(productVariant.getProductVariantId());
			subArrayList = new ArrayList<String>();
			for (Iterator<VariantValue> iterator2 = variantValueLst.iterator(); iterator2.hasNext();) {
				VariantValue variantValue = (VariantValue) iterator2.next();
				subArrayList.add(variantValue.getVariantVal());
			}

			String[] array = subArrayList.toArray(new String[subArrayList.size()]);
			mainArrayList.add(array);
		}

		LOGGER.info("mainArrayList:" + mainArrayList.size());
		getDeletePermutationIfSizeGreater(productVariantLst, productSkuLocalService, draftProductId,
				productMediaSKULocalService, mainArrayList);
		if (mainArrayList != null && mainArrayList.size() > 0) {
			List<ProductSKU> productSkuDefaultLst = productSkuLocalService
					.findByDraftProductIdNSkuName(Long.parseLong(draftProductId), "Default");
			if (productSkuDefaultLst.size() > 0) {
				// delete Default sku
				ProductSKU productSKU = productSkuDefaultLst.get(0);
				productSkuLocalService.deleteProductSKU(productSKU.getProductSKUId());
				List<ProductMediaSKU> productMediaSKULst = productMediaSKULocalService
						.findByProductSKUIdWithDraftProductId(Long.parseLong(draftProductId),
								productSKU.getProductSKUId());
				for (ProductMediaSKU productMediaSKU : productMediaSKULst) {
					productMediaSKULocalService.deleteProductMediaSKU(productMediaSKU.getProductMediaSKUId());
				}

			}
			List<String> variantPermutations = generatePermutations(mainArrayList);
			for (String skuName : variantPermutations) {
				// function for checking skuName is exist or not
				// condition for skuName perrmutaion size skuName=3

				String finalskuName = skuName.replaceAll("/", "");
				List<ProductSKU> productSkuNameLst = productSkuLocalService
						.findByDraftProductIdNSkuName(Long.parseLong(draftProductId), finalskuName);

				// existskuName=2;if skuNamesize==existskuName then not deleted if skuNamesize >
				// existskuName then deleted
				// System.out.println("skuName:--"+skuName);
				LOGGER.info("productSkuNameLst.size()--------->" + productSkuNameLst.size());
				if (productSkuNameLst.size() == 0 && !skuName.equals("")) {
					ProductSKU productSku = productSkuLocalService.createProductSKU(counterLocalService.increment());
					String skuCreationName = skuName.substring(0, skuName.length() - 1);
					productSku.setSkuName(finalskuName);
					productSku.setSkuCreationName(skuCreationName);
					productSku.setDraftProductId(Long.parseLong(draftProductId));
					productSku.setSkuId(sellerId + "/" + productSku.getProductSKUId() + "/" + draftProductId);
					// productSku.setImages("1");
					LOGGER.info("sessionskuName-------------::"+sessionskuName+"final skuname:"+finalskuName);
					if (sessionskuName != null && !sessionskuName.equals(finalskuName)) {
					productSkuLocalService.addProductSKU(productSku);
					addSkuLst.add(productSku);
					}
					if (sessionskuName==null) {
						productSkuLocalService.addProductSKU(productSku);
						addSkuLst.add(productSku);
					}
						
				}
			}
		} else {
			// function for checking skuName is exist or not
			List<ProductSKU> productSkuNameLst = productSkuLocalService
					.findByDraftProductIdNSkuName(Long.parseLong(draftProductId), "Default");
			if (productSkuNameLst.size() > 0) {
				ProductSKU productSkuName = productSkuNameLst.get(0);
				if (!productSkuName.getSkuName().equals("Default")) {
					ProductSKU productSku = productSkuLocalService.createProductSKU(counterLocalService.increment());
					String skuCreationName = "Default";
					productSku.setSkuName("Default");
					productSku.setSkuCreationName(skuCreationName);
					productSku.setDraftProductId(Long.parseLong(draftProductId));
					productSku.setSkuId(sellerId + "/" + productSku.getProductSKUId() + "/" + draftProductId);
					productSkuLocalService.addProductSKU(productSku);
					addSkuLst.add(productSku);
				}
			} else {
				ProductSKU productSku = productSkuLocalService.createProductSKU(counterLocalService.increment());
				String skuCreationName = "Default";
				productSku.setSkuName("Default");
				productSku.setSkuCreationName(skuCreationName);
				productSku.setDraftProductId(Long.parseLong(draftProductId));
				productSku.setSkuId(sellerId + "/" + productSku.getProductSKUId() + "/" + draftProductId);
				productSkuLocalService.addProductSKU(productSku);
				addSkuLst.add(productSku);
			}
		}
		// return productSkuLst;
	}

	public static List<String> generatePermutations(List<String[]> arrays) {
		List<String> permutations = new ArrayList<>();
		generatePermutationsHelper(arrays, 0, "", permutations);
		return permutations;
	}

	private static void generatePermutationsHelper(List<String[]> arrays, int index, String current,
			List<String> permutations) {
		if (index == arrays.size()) {
			permutations.add(current);
			return;
		}
		String[] currentArray = arrays.get(index);
		for (String element : currentArray) {
			generatePermutationsHelper(arrays, index + 1, current + element +  "/", permutations);
		}
	}
	
	public static void getDeletePermutationIfSizeGreater(List<ProductVariant> productVariantLst,ProductSKULocalService productSkuLocalService,String draftProductId,ProductMediaSKULocalService productMediaSKULocalService,ArrayList<String[]> mainArrayList) {
		LOGGER.info(":"+productVariantLst.size());
	int currentSize=productVariantLst.size();
	List<ProductSKU> pSkuLst=productSkuLocalService.findByDraftProductSkuId(Long.parseLong(draftProductId));
	List<String> variantPermutations = generatePermutations(mainArrayList);
	List<String> lstold=new ArrayList<String>();
	List<String> lstnew=new ArrayList<String>();
	for (ProductSKU productSKU : pSkuLst) {
		lstold.add(productSKU.getSkuName());
	}
	for (String skuName : variantPermutations) {
		lstnew.add(skuName.replaceAll("/", ""));
	}
	List<String> result =  lstold.stream().filter(item-> !lstnew.contains(item)).collect(Collectors.toList());
	for (String skuName : result) {
		List<ProductSKU>  lst=productSkuLocalService.findByDraftProductIdNSkuName(Long.parseLong(draftProductId), skuName);
		try {
			if(lst.size()>0) {
				ProductSKU productSKU=	lst.get(0);
				if(!productSKU.getSkuName().equals("Default")) {
				productSkuLocalService.deleteProductSKU(productSKU.getProductSKUId());
				getRemoveMediaSku(productMediaSKULocalService,draftProductId,productSKU.getProductSKUId());
				}
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(":-final reqult SkuName--->"+skuName);
	}
		/*
		 * for (ProductSKU productSKU : pSkuLst) { String
		 * skuCreationName=productSKU.getSkuCreationName(); String[]
		 * str=skuCreationName.split("/"); int existingSkuSize=str.length; try {
		 * if(existingSkuSize>currentSize) {
		 * if(!productSKU.getSkuName().equals("Default")) {
		 * productSkuLocalService.deleteProductSKU(productSKU.getProductSKUId());
		 * getRemoveMediaSku(productMediaSKULocalService,draftProductId,productSKU.
		 * getProductSKUId()); } }if(existingSkuSize<currentSize) {
		 * productSkuLocalService.deleteProductSKU(productSKU.getProductSKUId());
		 * getRemoveMediaSku(productMediaSKULocalService,draftProductId,productSKU.
		 * getProductSKUId()); }if(existingSkuSize==currentSize) {
		 * 
		 * 
		 * } } catch (PortalException e) { e.printStackTrace(); } }
		 */
		
	}
	
	
	private static void getRemoveMediaSku(ProductMediaSKULocalService productMediaSKULocalService,String draftProductId, Long productskuId) {
		List<ProductMediaSKU>  productMediaSKULst=productMediaSKULocalService.findByProductSKUIdWithDraftProductId(Long.parseLong(draftProductId), productskuId);
		try {
			for (ProductMediaSKU productMediaSKU : productMediaSKULst) {
				productMediaSKULocalService.deleteProductMediaSKU(productMediaSKU.getProductMediaSKUId());
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
	
	@Reference
	private VariantValueLocalService variantValueLocalService;

	@Reference
	private ProductVariantLocalService productVariantLocalService;

	@Reference
	private ProductLocalService productLocalService;

	@Reference
	private ProductSKULocalService productSkuLocalService;
	
	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;

	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private SKUMediaHandler skuMediaHandler;

}