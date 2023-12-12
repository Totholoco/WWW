package com.totoinc.miejemplo;

public class UsersItem {

    String userID;
    String UsuarioReg;
    String Correo;
    String ClaveReg;

    public UsersItem() {
    }

    public UsersItem(String userID, String UsuarioReg, String Correo, String ClaveReg) {
        this.userID = userID;
        this.UsuarioReg = UsuarioReg;
        this.Correo = Correo;
        this.ClaveReg = ClaveReg;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsuarioReg() {
        return UsuarioReg;
    }

    public void setUsuarioReg(String usuarioReg) {
        this.UsuarioReg = usuarioReg;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    public String getClaveReg() {
        return ClaveReg;
    }

    public void setClaveReg(String claveReg) {
        this.ClaveReg = claveReg;
    }
}
