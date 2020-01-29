package com.cursovaya.objects;

import com.cursovaya.interfaces.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class user implements workWithDb{

    private int rowid;
    private String surname, name;
    private String login, pass;
    private whois typeUset;
    private boolean isVoted;
    private boolean isRated;

    public boolean isVoted() {
        return isVoted;
    }

    public void setVoted(boolean voted) {
        this.isVoted = voted;
    }

    public boolean isRated() {
        return isRated;
    }

    public void setRated(boolean rated) {
        this.isRated = rated;
    }

    public user(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public int getRowid() {
        return rowid;
    }

    public void setRowid(int rowid) {
        this.rowid = rowid;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    void setLogin(String login) {
        this.login = login;
    }

    String getPass() {
        return pass;
    }

    void setPass(String pass) {
        this.pass = pass;
    }

    public whois getTypeUset() {
        return typeUset;
    }

    public void setTypeUset(whois typeUset) {
        this.typeUset = typeUset;
    }

    public user(int rowid,
                String surname,
                String name,
                String login,
                String pass,
                int typeUset,
                boolean isVoted,
                boolean isRated) {
        this.rowid = rowid;
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.pass = pass;
        switch (typeUset){
            case 0:
                this.typeUset = whois.jury;
                break;
            case 1:
                this.typeUset = whois.participant;
                break;
            case 2:
                this.typeUset = whois.guest;
                break;
        }
        this.isVoted = isVoted;
        this.isRated = isRated;
    }

    public user() {
    }

    @Override
    public void addInfo() throws SQLException {
        /*
        добавить пользователя
         */
        PreparedStatement a = connection.getConn().prepareStatement
                ("INSERT INTO `user` (`fio_f`, `fio_i`, `login`, `pass`, `whois`) " +
                "VALUES (?,?,?,?,?);");
        a.setString(1,getSurname());
        a.setString(2,getName());
        a.setString(3,getLogin());
        a.setString(4,getPass());
        a.setInt(5,getTypeUset().getRelationBtwNumber());
        a.executeUpdate();
        connection.setStat(connection.getConn().prepareStatement
                ("SELECT rowid from user where login = ?;"));
        connection.getStat().setString(1, login);
        ResultSet b = connection.getStat().executeQuery();
        b.next();
        this.rowid = b.getInt("rowid");
    }

    @Override
    public void removeInfo() {

    }

    @Override
    public ArrayList<film> getInfo(String query) throws SQLException {
        return null;
    }

    @Override
    public boolean isItExist(String query) throws SQLException {
        PreparedStatement a = connection.getConn().prepareStatement(query);
        a.setString(1, login);
        boolean passE = query.matches("(.*)pass(.*)");
        if (passE) {
            a.setString(2, pass);
        }
        ResultSet b = a.executeQuery();
        if (b.next())
            if (passE)
                if (b.getString("login").equals(login) && b.getString("pass").equals(pass)) return true;
                else return false;
                else return true;
             else return false;
    }

    @Override
    public String getArtefact() {
        return null;
    }

}
