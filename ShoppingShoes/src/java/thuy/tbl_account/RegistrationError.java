/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_account;

import java.io.Serializable;

/**
 *
 * @author vtkth
 */
public class RegistrationError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String lastnameLenghtErr;
    private String middleNameLenghtErr;
    private String firstnameLenghtErr;
    private String addressLenghtErr;
    private String phoneErr;
    private String dupplcateUsername;

    public RegistrationError() {
    }

    public RegistrationError(String usernameLengthErr, String passwordLengthErr, String confirmNotMatch, String lastnameLenghtErr, String middleNameLenghtErr, String firstnameLenghtErr, String addressLenghtErr, String phoneErr, String dupplcateUsername) {
        this.usernameLengthErr = usernameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.confirmNotMatch = confirmNotMatch;
        this.lastnameLenghtErr = lastnameLenghtErr;
        this.middleNameLenghtErr = middleNameLenghtErr;
        this.firstnameLenghtErr = firstnameLenghtErr;
        this.addressLenghtErr = addressLenghtErr;
        this.phoneErr = phoneErr;
        this.dupplcateUsername = dupplcateUsername;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getLastnameLenghtErr() {
        return lastnameLenghtErr;
    }

    public void setLastnameLenghtErr(String lastnameLenghtErr) {
        this.lastnameLenghtErr = lastnameLenghtErr;
    }

    public String getMiddleNameLenghtErr() {
        return middleNameLenghtErr;
    }

    public void setMiddleNameLenghtErr(String middleNameLenghtErr) {
        this.middleNameLenghtErr = middleNameLenghtErr;
    }

    public String getFirstnameLenghtErr() {
        return firstnameLenghtErr;
    }

    public void setFirstnameLenghtErr(String firstnameLenghtErr) {
        this.firstnameLenghtErr = firstnameLenghtErr;
    }

    public String getAddressLenghtErr() {
        return addressLenghtErr;
    }

    public void setAddressLenghtErr(String addressLenghtErr) {
        this.addressLenghtErr = addressLenghtErr;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    public String getDupplcateUsername() {
        return dupplcateUsername;
    }

    public void setDupplcateUsername(String dupplcateUsername) {
        this.dupplcateUsername = dupplcateUsername;
    }
    
}
