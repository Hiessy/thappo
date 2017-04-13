package org.thappo.domain.feature.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addresId;
	
	@Column(name = "street_nbr")
	private String streetNumber;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "floor_number")
	private String floorNumber;

	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "latitud")
	private String latitud;
	
	@Column(name = "longitud")
	private String longitud;

	public Integer getAddresId() {
		return addresId;
	}

	public void setAddresId(Integer addresId) {
		this.addresId = addresId;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Address [addresId=" + addresId + ", streetNumber=" + streetNumber + ", streetName=" + streetName
				+ ", floorNumber=" + floorNumber + ", postalCode=" + postalCode + ", city=" + city + ", province="
				+ province + ", country=" + country + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
}
