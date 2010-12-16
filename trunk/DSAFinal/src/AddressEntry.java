import java.io.Serializable;

public class AddressEntry implements Comparable<AddressEntry>, Serializable{
	private String name;
	private String phone;
	private String address;
	
	public AddressEntry(String name, String phone, String address){
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public String toString()
	{
		return name;
	}

	@Override
	public int compareTo(AddressEntry entry) {
		return this.name.compareToIgnoreCase(entry.getName());
	}
}