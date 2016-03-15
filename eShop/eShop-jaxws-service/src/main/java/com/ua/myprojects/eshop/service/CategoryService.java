package com.ua.myprojects.eshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.ua.myprojects.eshop.service.model.Category;
import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.RequestStatus;
import com.ua.myprojects.eshop.service.model.StatusData;

@WebService(
		serviceName = "CategoryService", portName = "CategoryServicePort",
		targetNamespace = "com/ua/myprojects/eshop/service/jaxws")
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CategoryService {// implements CategoryServiceInterface {
	@WebMethod
	public CommonResponse<List<Category>> queryProductCategories() {
		CommonResponse<List<Category>> resp = new CommonResponse<List<Category>>();

		List<Category> content = new ArrayList<Category>();
		Category cat = new Category();
		cat.setTitle("title111");
		content.add(cat);
		resp.setContent(content);

		StatusData status = new StatusData();
		status.setRequestStatus(RequestStatus.SUCCESS);
		resp.setStatus(status);
		return resp;
	}
}
