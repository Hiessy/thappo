package org.thappo.domain.feature.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subcategories")
public class SubCategory {
	
	@Id
	@GeneratedValue
	@Column(name="subcategory_id")
	private Integer subcategory;
	
	@Column(name="subcategory_name")
	private String subcategoryName;
	
	@Column(name="subcategory_description")
	private String subcategoryDescription;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public Integer getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Integer subcategory) {
		this.subcategory = subcategory;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getSubcategoryDescription() {
		return subcategoryDescription;
	}

	public void setSubcategoryDescription(String subcategoryDescription) {
		this.subcategoryDescription = subcategoryDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [subcategory=" + subcategory + ", subcategoryName=" + subcategoryName
				+ ", subcategoryDescription=" + subcategoryDescription + ", category=" + category + "]";
	}
	
	
}
