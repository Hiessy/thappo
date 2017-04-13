package org.thappo.domain.feature.business.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.thappo.domain.feature.user.model.User;

@Entity
@Table(name = "businesses")
public class Business {

	@Id
	@Column(name = "business_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer businessId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy="business")
	private List<Branch> branches = new ArrayList<Branch>();
	
	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	
	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", user=" + user + ", category=" + category + "]";
	}

}
