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
public class tbl_accountDTO implements Serializable {

    private String username;
    private String password;
    private String cusID;

    public tbl_accountDTO() {
    }

    public tbl_accountDTO(String username, String password, String cusID) {
        this.username = username;
        this.password = password;
        this.cusID = cusID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

}
