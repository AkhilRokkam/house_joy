package com.ts.housejoy.service;

import java.util.*;

import com.ts.housejoy.dao.*;
import com.ts.housejoy.dto.*;

public class HouseJoyService {

	public boolean addCategory(Category category) {
		return CategoryDAO.add(category);
	}

	public boolean deleteCategory(int categoryId) {
		return CategoryDAO.delete(categoryId);
	}

	public Category getCategory(int categoryId) {
		return CategoryDAO.get(categoryId);
	}

	public List<Category> getCategories() {
		return CategoryDAO.getCategories();
	}

	public boolean addSubCategory(SubCategory subCategory) {
		return SubCategoryDAO.add(subCategory);
	}

	public boolean deleteSubCategory(int subCategoryId) {
		return SubCategoryDAO.delete(subCategoryId);
	}

	public SubCategory getSubCategory(int subCategoryId) {
		return SubCategoryDAO.get(subCategoryId);
	}
	
	
	public List<SubCategory> getSubCategories() {
		return SubCategoryDAO.getSubCategories();
	}

	public List<SubCategory> getSubCategories(int categoryId) {
		return SubCategoryDAO.getSubCategories(categoryId);
	}
	

	public boolean addServiceType(ServiceType serviceType) {
		return ServiceTypeDAO.add(serviceType);
	}

	public boolean deleteServiceType(int serviceTypeId) {
		return ServiceTypeDAO.delete(serviceTypeId);
	}

	public ServiceType getServiceType(int serviceTypeId) {
		return ServiceTypeDAO.get(serviceTypeId);
	}

	public List<ServiceType> getServiceTypes(int subCategoryId) {
		return ServiceTypeDAO.getServiceTypes(subCategoryId);
	}
	
	public List<ServiceType> getForceServiceTypes(int userId) {
		return ServiceTypeDAO.getServiceTypes(userId);
	}
	
	
	public List<ServiceType> getServiceTypes() {
		return ServiceTypeDAO.getServiceTypes();
	}
	

	public User registerUser(User user) {
		return UserDAO.register(user);
	}

	public User loginUser(String email, String password) {
		return UserDAO.login(email,password);
	}
	
	
	public User loginAdmin(String email, String password) {		
		return UserDAO.loginAdmin(email,password);			
	}

	public User getUserDetails(int userId) {
		return new UserDAO().get(userId);
	}

	public User getUserDetails(String emailId) {
		return new UserDAO().get(emailId);
	}	

	public Address addAddress(Address address) {
		return new AddressDAO().add(address);
	}

	public boolean deleteAddress(int addressId) {
		return new AddressDAO().delete(addressId);
	}

	public Address getAddress(int addressId) {
		return new AddressDAO().get(addressId);
	}

	public List<Address> getAddressList(int userId) {
		return new AddressDAO().getAddressList(userId);
	}

	public boolean updateUserDetails(String password, long mobileNumber, int userId) {
		return new UserDAO().updateUserDetails(password, mobileNumber, userId);
	}

	public Force registerForce(Force force) {
		return ForceDAO.register(force);
	}	
	
	public Force loginForce(String email, String password) {
		return new ForceDAO().login(email, password);
	}	

	public Force getForceDetails(int userId) {
		return new ForceDAO().get(userId);
	}

	public Force getForceDetails(String emailId) {
		return new ForceDAO().get(emailId);
	}

	public boolean approveForce(int userId,int serviceId,char status) {
		return new ForceDAO().approveForce(userId,serviceId,status);
	}	
}
