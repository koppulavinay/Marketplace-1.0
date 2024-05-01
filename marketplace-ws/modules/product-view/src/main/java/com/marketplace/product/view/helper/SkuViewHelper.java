//package com.marketplace.product.view.helper;
//
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.marketplace.product.master.service.ProductLocalService;
//import com.marketplace.product.sku.master.model.ProductSKU;
//import com.marketplace.product.sku.master.service.ProductSKULocalService;
//import com.marketplace.product.variant.master.model.ProductVariant;
//import com.marketplace.product.variant.master.service.ProductVariantLocalService;
//import com.marketplace.variant.values.master.model.VariantValue;
//import com.marketplace.variant.values.master.service.VariantValueLocalService;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(immediate = true, service = SkuViewHelper.class)
//public class SkuViewHelper {
//
//	public static List<ProductSKU> getPermutationVariant(String draftProductId) throws PortalException {
//		
//		_log.info("---------------- Inside SkuHelper Method ----------------");
//		// Fetching Basic Information Form Data
//		List<ProductSKU> productSkuLst = new ArrayList<>();
//		List<ProductVariant> productVariantLst= productVariantLocalService.findByDraftProductId(Long.parseLong(draftProductId));
//		ArrayList<String[]> mainArrayList = new ArrayList<String[]>();
//		ArrayList<String> subArrayList;
//		for (Iterator<ProductVariant> iterator = productVariantLst.iterator(); iterator.hasNext();) {
//			ProductVariant productVariant = (ProductVariant) iterator.next();
//			List<VariantValue> variantValueLst=variantValueLocalService.findByVariantValueId(productVariant.getProductVariantId());
//			subArrayList = new ArrayList<String>();
//			for (Iterator<VariantValue> iterator2 = variantValueLst.iterator(); iterator2.hasNext();) {
//				VariantValue variantValue = (VariantValue) iterator2.next();
//				    subArrayList.add(variantValue.getVariantValue()); 
//			}
//			
//			String[] array = subArrayList.toArray(new String[subArrayList.size()]);
//			 mainArrayList.add(array);
//		}
//		 List<String> variantPermutations = generatePermutations(mainArrayList);
//		 for (String variants : variantPermutations) {
//			 
//			 System.out.println("variants:"+variants);
//			
//			 ProductSKU productSku =
//			  productSkuLocalService.createProductSKU(CounterLocalServiceUtil.increment());
//			  productSku.setSkuName(variants);
//			  productSku.setDraftProductId(Long.parseLong(draftProductId));
//			  productSkuLocalService.addProductSKU(productSku);
//			  productSkuLst.add(productSku);
//			 
//	            
//	        }
//		 
//		 System.out.println("productSkuLst:-->"+productSkuLst);
//		 return productSkuLst;
//		
//	}
//	
//	@Reference
//	private static VariantValueLocalService variantValueLocalService;
//	
//	
//	@Reference
//	private static ProductVariantLocalService productVariantLocalService;
//	
//
//	@Reference
//	private static ProductLocalService productLocalService;
//	
//	
//	@Reference
//	private static ProductSKULocalService productSkuLocalService;
//	
//	   public static List<String> generatePermutations(List<String[]> arrays) {
//	        List<String> permutations = new ArrayList<>();
//	        generatePermutationsHelper(arrays, 0, "", permutations);
//	        return permutations;
//	    }
//
//	    private static void generatePermutationsHelper(List<String[]> arrays, int index, String current, List<String> permutations) {
//	        if (index == arrays.size()) {
//	            permutations.add(current);
//	            return;
//	        }
//	        String[] currentArray = arrays.get(index);
//	        for (String element : currentArray) {
//	            generatePermutationsHelper(arrays, index + 1, current + element, permutations);
//	        }
//	    }
//	    
//	private static final Log _log = LogFactoryUtil.getLog(SkuViewHelper.class);
//	
//}
