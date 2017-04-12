package org.thappo.api.models.generics;

public class AddressDTO {
	
	private int addressId;
	private String streetNumber;
	private String streetName;
	private String floorNumber;
	private String postalCode;
	private String city;
	private String province;
	private String country;
	private String latitud;
	private String longitud;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
		return "AddressDTO [addressId=" + addressId + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", floorNumber=" + floorNumber + ", postalCode=" + postalCode + ", city=" + city + ", province=" + province + ", country=" + country + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]";
	}	
	
}
