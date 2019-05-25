package com.siva.cricketcards.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.siva.cricketcards.dto.PlayerStats;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class StatisticsServiceTest {

	@Autowired
	StatisticsService statisticsService;

//	@Test
	public void testName() {
		//starting from 858
		// Dhoni's - 7593
		for (int i = 7291; i < 100000; i++) {
			PlayerStats stats = statisticsService.getPlayerStats(i);
			if (stats.getMatches() != 0)
				System.out.println(i);
			if (stats.getRuns() == 10500 && stats.getHighestScore().equals("183*"))
				System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" + i);
		}
	}

//	@Mock
//	CatalogClient catalogClient;
//	@Mock
//	CacheCompressionService cacheCompressionService;
//	@Mock
//	ConsolidatedCatalogClientsModelDozerMapper consolidatedCatalogClientsModelDozerMapper;
//
//	@InjectMocks
//	CatalogCacheService catalogCacheService;
//
//	@Test
//	public void shouldInteractWithCatalogClientAndCompressResponse() {
//		String sku = "1";
//		String storeId = "0100";
//		String requestType = "ecom";
//		String clientId = "ecombuy";
//		String showInternal = "true";
//		String inventoryAware = "true";
//
//		String response = "{\"Sku\": [{\"BrandAbbrName\": \"gap\", \"MarketCode\": \"us\","
//				+ " \"SkuBusinessId\": \"0000790120035\", \"ParentBusinessIds\": {\"Id\": [\"000079012\", "
//				+ "\"000079\"] }, \"SkuDescription\": [{\"value\": \"$35.00\", \"locale\": \"en_US\"} ], "
//				+ "\"Active\": true, \"StyleBusinessId\": \"000079\", \"StyleDescription\": [{\"value\": "
//				+ "\"Gap GiftCard\", \"locale\": \"en_US\"} ], \"StyleColorBusinessId\": \"000079012\", "
//				+ "\"ColorDescription\": [{\"value\": \"blue\", \"locale\": \"en_US\"} ], \"SizeVariantName\": "
//				+ "[{\"value\": \"Regular\", \"locale\": \"en_US\"} ], \"SizeDimensionOne\": "
//				+ "[{\"value\": \"$35.00\", \"locale\": \"en_US\"} ], \"SizeCode\": \"0035\", \"UpcCode\": \"NA\", "
//				+ "\"TaxCode\": \"GC\", \"StoreExclusive\": false, \"OnSale\": false, \"Reservable\": true, "
//				+ "\"CurrentPrice\": 35.0, \"RegularPrice\": 35.0, \"DiscountAmount\": 0.0, \"InventoryStatus\": "
//				+ "\"IN_STOCK\", \"Orderable\": false, \"OnOrderDate\": \"2019-05-04-04:00\", \"MaxOrderQuantityAllowed\": 5,"
//				+ " \"HazardousMaterial\": false, \"GiftWrappable\": false, \"InternationallyShippable\": false,"
//				+ " \"StyleMarketingFlagId\": 0, \"ColorId\": 0, \"BaseColorId\": 1021, \"ProductTypeId\": 5, "
//				+ "\"ProductTypeName\": \"STORED VALUE CARDS FIXED\", \"anies\": null, \"InternalOnly\": "
//				+ "{\"SizeVariantId\": 1, \"MerchandiseTypeId\": 3, \"PriceTypeId\": 1, \"InventoryStatusId\": 0,"
//				+ " \"StyleCatalogItemId\": 1132789, \"StyleColorCatalogItemId\": 1132791, \"SkuCatalogItemId\": 1132794, "
//				+ "\"PurchaseSizeId\": 0, \"ParentCatalogItemIds\": {\"Id\": [1132791, 1132789 ] }, "
//				+ "\"StyleMarketingFlagIds\": [], \"StatusCode\": 601, \"anies\": null } } ] }";
//
//		String productInfo = "{\"categoryNumber\":\"72205\",\"styleCatalogItemId\":5098349,\"inventoryLevel\":0,"
//				+ "\"marketingFlagId\":0,\"productTypeId\":0,\"maxOrderQuantityAllowed\":0,\"merchandiseType\":0,"
//				+ "\"priceType\":0,\"reservable\":false}";
//
//		byte[] compressedBytes = new byte[2];
//		try {
//			ProductInfo productInfoObj = new ProductInfo();
//			productInfoObj.setCategoryNumber("72205");
//			productInfoObj.setStyleCatalogItemId(BigInteger.valueOf(5098349));
//
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			Skus skus = mapper.readValue(response, Skus.class);
//			Mockito.when(catalogClient.getSkus(sku, storeId, requestType, clientId, showInternal, inventoryAware, null))
//					.thenReturn(skus);
//
//			Mockito.when(consolidatedCatalogClientsModelDozerMapper.map(skus.getSkus().get(0)))
//					.thenReturn(productInfoObj);
//
//			Mockito.when(cacheCompressionService.compressString(productInfo)).thenReturn(compressedBytes);
//
//			byte[] actualBytes = catalogCacheService.fetchOrFillProductCache(sku, storeId, requestType, clientId,
//					showInternal, inventoryAware, null);
//
//			Assert.assertEquals(actualBytes, compressedBytes);
//		} catch (IOException e) {
//			Assert.fail();
//		}
//	}
//
//	@Test
//	public void shouldThrowExceptionWhenInteractionWithCatalogClientGivesEmptyResponse() {
//		String sku = "1";
//		String storeId = "0100";
//		String requestType = "ecom";
//		String clientId = "ecombuy";
//		String showInternal = "true";
//		String inventoryAware = "true";
//
//		Mockito.when(catalogClient.getSkus(sku, storeId, requestType, clientId, showInternal, inventoryAware, null))
//				.thenReturn(new Skus());
//		try {
//			catalogCacheService.fetchOrFillProductCache(sku, storeId, requestType, clientId, showInternal,
//					inventoryAware, null);
//			Assert.fail();
//		} catch (RuntimeException e) {
//			Assert.assertEquals("Invalid Response", e.getMessage());
//		}
//		Mockito.when(catalogClient.getSkus(sku, storeId, requestType, clientId, showInternal, inventoryAware, null))
//				.thenReturn(new Skus());
//		try {
//			catalogCacheService.fetchOrFillProductCache(sku, storeId, requestType, clientId, showInternal,
//					inventoryAware, null);
//			Assert.fail();
//		} catch (RuntimeException e) {
//			Assert.assertEquals("Invalid Response", e.getMessage());
//		}
//	}

}
