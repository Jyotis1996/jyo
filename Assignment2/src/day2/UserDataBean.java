package day2;

/**
 * UserDataBean class has getter and setter methods for username and password
 * @author Jyoti
 * Date-2019/09/02
 */
public class UserDataBean {
	private String userId = "";
	private String password = "";
	private String salutation = "";
	private String firstName = "";
	private String middleInitial = "";
	private String lastName = "";
	private String sex = "";
	private String emailID = "";
	private String birthDate = "";
	private String address = "";
	private String areaOfInterest = "";
	private String otherInterest = "";
	private String category = "";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public String getOtherInterest() {
		return otherInterest;
	}

	public void setOtherInterest(String otherInterest) {
		this.otherInterest = otherInterest;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
