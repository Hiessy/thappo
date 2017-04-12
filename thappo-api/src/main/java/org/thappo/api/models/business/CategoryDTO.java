package org.thappo.api.models.business;

import java.util.List;

public class CategoryDTO {
	private int categoryId;
	private String categoryName;
	private String description;
	private List<SubcategoryDTO> subcategories;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<SubcategoryDTO> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<SubcategoryDTO> subcategories) {
		this.subcategories = subcategories;
	}
	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description + ", subcategories=" + subcategories + "]";
	}
	
}
