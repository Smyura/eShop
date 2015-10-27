package com.ua.myprojects.eshop.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ua.myprojects.eshop.service.model.Category;
import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.RequestStatus;

@ContextConfiguration({ "classpath:applicationContext.xml" })
public class CategoryServiceTest extends AbstractTestNGSpringContextTests {
	CategoryServiceInterface service;

	private CategoryServiceInterface prepateService() {
		return applicationContext.getBean(CategoryService.class);
	}

	@BeforeClass
	public void init() {
		service = prepateService();
	}

	@Test
	public void testServiceSuccess() {
		CommonResponse<List<Category>> response = service.queryProductCategories();
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatus().getRequestStatus(), RequestStatus.SUCCESS);
		Assert.assertFalse(CollectionUtils.isEmpty(response.getContent()));
	}
}
