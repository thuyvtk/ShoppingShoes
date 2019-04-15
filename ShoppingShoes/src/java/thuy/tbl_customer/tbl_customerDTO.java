/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_customer;

import java.io.Serializable;

/**
 *
 * @author vtkth
 */
public class tbl_customerDTO implements Serializable{
    private String custID;
    private String lastName;
    private String middleName;
    private String firstname;
    private String address;
    private String phone;
    private int custLevel;

    public tbl_customerDTO() {
    }

    public tbl_customerDTO(String custID, String lastName, String middleName, String firstname, String address, String phone, int custLevel) {
        this.custID = custID;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.custLevel = custLevel;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(int custLevel) {
        this.custLevel = custLevel;
    }
    
}
