package SalesPoints;

import java.io.IOException;
import java.io.Serializable;

public abstract class User implements Serializable {
    protected String userID;
    protected String nameUser;
    protected  String emailUser;
    protected String passwordUser;

    public User(String userID, String nameUser,String emailUser, String passwordUser) {
        this.userID = userID;
        this.nameUser= nameUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public User(String userID) {
        this.userID = userID;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getNameUser() {
        return nameUser;
    }
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    public String getEmailUser() {
        return emailUser;
    }
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    public String getPasswordUser() {
        return passwordUser;
    }
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public abstract boolean login(String userID, String passwordUser) throws IOException;

}