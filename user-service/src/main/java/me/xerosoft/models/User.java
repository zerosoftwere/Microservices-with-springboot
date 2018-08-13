package me.xerosoft.models;

/**
 * Created by xero on 8/10/18.
 */
public class User extends BaseEntity<String> {
    private String address;
    private String city;
    private String phoneNo;

    public User(String id, String name, String address, String city, String phoneNo) {
        super(id, name);
        this.address = address;
        this.city = city;
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
