package org.thappo.api.models.business;

public class SubcategoryDTO {

	private int subCategoryId;
	private String subCategoryName;
	private String description;
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Subcategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", description=" + description + "]";
	}
	
}
