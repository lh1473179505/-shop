package cn.sjxy.shop.domain;

public class Member {

	private Integer id = Integer.valueOf("-1"); 	// 会员ID属性
	private String userName = ""; 					// 账户属性
	private String trueName = ""; 					// 真实姓名属性
	private String password = ""; 						// 密码属性
	private String city = ""; 						// 所在城市属性
	private String address = ""; 					// 地址属性
	private String postcode = ""; 					// 邮编属性
	private String cardno = ""; 						// 证件号码属性
	private String cardtype = ""; 					// 证件类型属性
	private String tel = ""; 						// 联系电话属性
	private String email = ""; 						// 邮箱属性
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
