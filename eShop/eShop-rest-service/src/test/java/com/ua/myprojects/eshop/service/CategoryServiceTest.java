//package com.ua.myprojects.eshop.service;
//
//import java.util.List;
//
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.ua.myprojects.eshop.service.model.Category;
//import com.ua.myprojects.eshop.service.model.CommonResponse;
//import com.ua.myprojects.eshop.service.model.MessageCode;
//import com.ua.myprojects.eshop.service.model.RequestStatus;
//
//@ContextConfiguration({ "classpath:applicationContext.xml" })
//public class CategoryServiceTest extends AbstractTestNGSpringContextTests {
//	CategoryServiceInterface service;
//
//	private CategoryServiceInterface prepateService() {
//		return applicationContext.getBean(CategoryService.class);
//	}
//
//	@BeforeClass
//	public void init() {
//		service = prepateService();
//	}
//
//	@Test
//	public void testServiceSuccess() {
//		CommonResponse<List<Category>> response = service.queryProductCategories();
//
//		response = service.queryProductCategories();
//
//		Assert.assertNotNull(response);
//		// Assert.assertEquals(response.getStatus().getRequestStatus(),
//		// RequestStatus.SUCCESS);
//		// Assert.assertFalse(CollectionUtils.isEmpty(response.getContent()));
//
//		Assert.assertEquals(response.getStatus().getRequestStatus(), RequestStatus.ERROR);
//		Assert.assertNull(response.getContent());
//		Assert.assertNotNull(response.getStatus().getMessageDatas());
//		Assert.assertEquals(response.getStatus().getMessageDatas().size(), 1);
//		Assert.assertEquals(response.getStatus().getMessageDatas().get(0).getMsgCode(),
//				MessageCode.ESHOPDB0xx_DB_CONNECTION_ERROR.getMsgCode());
//
//	}

//import junit.framework.Assert;
//
//import org.glassfish.jersey.server.ResourceConfig;
//import org.glassfish.jersey.test.JerseyTest;
//import org.junit.Test;
//
//import com.ua.myprojects.eshop.service.model.Category;
//import com.ua.myprojects.eshop.service.model.CommonResponse;
//
//public class CategoryServiceTest extends JerseyTest {
//	private String url = "http://localhost:8080/eShop_service";
//	private CategoryServiceInterface service;
//
//	@Override
//	protected Application configure() {
//		return new ResourceConfig(CategoryServiceInterface.class);
//	}
//
//	@Test
//	public void testCategoryError() {
//		CommonResponse<List<Category>> response = service.queryProductCategories();
//		Assert.assertNotNull(response);
//	}
//
// }
