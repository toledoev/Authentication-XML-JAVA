import java.io.Serializable;


public class Customer implements Serializable {

	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private int salesRepEmployeeNumber;
	private Double creditLimit;


	public Customer() {
	}


	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getContactLastName() {
		return contactLastName;
	}


	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}


	public String getContactFirstName() {
		return contactFirstName;
	}


	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}


	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}


	public Double getCreditLimit() {
		return creditLimit;
	}


	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}


	@Override
	public String toString() {
		return "Customer Details: \n\t customerNumber=" + customerNumber
				+ "\n\t customerName=" + customerName
				+ "\n\t contactLastName=" + contactLastName
				+ "\n\t contactFirstName=" + contactFirstName
				+ "\n\t phone=" + phone
				+ "\n\t city=" + city
				+ "\n\t state=" + state
				+ "\n\t postalCode=" + postalCode
				+ "\n\t country=" + country
				+ "\n\t addressLine1=" + addressLine1
				+ "\n\t addressLine2=" + addressLine2
				+ "\n\t salesRepEmployeeNumber=" + salesRepEmployeeNumber
				+ "\n\t creditLimit=" + creditLimit ;
	}


}
