package com.ua.myprojects.eshop.service.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.ua.myprojects.eshop.service.model.Category;
import com.ua.myprojects.eshop.service.model.CommonResponse;

@WebService(
		serviceName = "CategoryService", portName = "CategoryServicePort",
		targetNamespace = "com/ua/myprojects/eshop/service/jaxws")
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CategoryServiceInterface {
	@WebMethod
	CommonResponse<List<Category>> queryProductCategories();
}
