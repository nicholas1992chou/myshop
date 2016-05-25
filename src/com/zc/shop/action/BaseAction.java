package com.zc.shop.action;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zc.shop.Utils.FileUploadUtil;
import com.zc.shop.service.AccountService;
import com.zc.shop.service.CategoryService;
import com.zc.shop.service.CustomerService;
import com.zc.shop.service.ForderService;
import com.zc.shop.service.ProductService;
import com.zc.shop.service.SorderService;

@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements SessionAware, RequestAware, ApplicationAware, ModelDriven<T>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//分页参数
	protected Integer page;
	protected Integer rows;
	protected Long total;
	
	//上传文件的三个属性
	protected File srcFile;
	protected String srcFileFileName;
	protected String srcFileContentType;
	
	protected FileUploadUtil fileUploadUtil;
	//批量删除
	protected String ids;
	
	//与ajax交互
	protected InputStream inputStream ;
	//封装分页数据
	protected Map<String, Object> pageMap = new HashMap<String, Object>();
	//封装query结果记录以json格式传递给前端
	protected List<T> jsonList = null;
	
	
	protected CategoryService categoryService;
	protected AccountService accountService;
	protected ProductService productService;
	protected ForderService forderService;
	protected SorderService sorderService;
	protected CustomerService customerService;
	
	
	//模型驱动，将请求数据封装为对象。
	protected T model;
		
	@SuppressWarnings("rawtypes")
	protected Class clazz;
	
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		application = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	

	@SuppressWarnings("rawtypes")
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];;
		try {
			model = (T) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return model;
	}

	public void setSrcFile(File srcFile) {
		this.srcFile = srcFile;
	}

	public void setSrcFileContentType(String srcFileContentType) {
		this.srcFileContentType = srcFileContentType;
	}

	public void setSrcFileFileName(String srcFileFileName) {
		this.srcFileFileName = srcFileFileName;
	}

	public FileUploadUtil getFileUploadUtil() {
		return fileUploadUtil;
	}

	public void setFileUploadUtil(FileUploadUtil fileUploadUtil) {
		this.fileUploadUtil = fileUploadUtil;
	}

	public void setForderService(ForderService forderService) {
		this.forderService = forderService;
	}

	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	
}
