package org.thappo.api.models.business;

import java.util.List;

import org.thappo.api.models.user.UserDTO;

public class BusinessDTO {
	
    private Integer businessId;
    private String businessName;
    private UserDTO user;
    private CategoryDTO category;
    private List<BranchDTO> branchs;
    
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public List<BranchDTO> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<BranchDTO> branchs) {
		this.branchs = branchs;
	}
	
	@Override
	public String toString() {
		return "BusinessDTO [businessId=" + businessId + ", businessName=" + businessName + ", user=" + user + ", category=" + category + ", branchs=" + branchs + "]";
	}
	
}
