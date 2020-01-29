package com.cursovaya.objects;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cursovaya.interfaces.workWithDb;

public class film implements workWithDb {
    private Integer rowid;
    private String name;
    private user director;
    private categories categories;
    private Integer rating;
    private Integer votes; //количество голосов для каждой категории
    private String describing;

    public Integer getUsersVoted() {
        return usersVoted;
    }

    public void setUsersVoted(Integer usersVoted) {
        this.usersVoted = usersVoted;
    }

    private Integer usersVoted;


    public film(Integer rowid,
                String name,
                user director,
                categories categories,
                Integer rating,
                Integer votes,
                String describing,
                Integer usersVoted) {
        this.rowid = rowid;
        this.name = name;
        this.director = director;
        this.categories = categories;
        this.rating = rating; // средний рейтинг
        this.votes = votes; // количество голосов
        this.describing = describing; // описание фильма
        this.usersVoted = usersVoted; // количество проголосовавших
    }

    public film() {
    }


    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }




    public user getDirector() {
        return director;
    }

    public void setDirector(user director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public categories getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "film{" +
                "name='" + name + '\'' +
                ", categories=" + categories +
                '}';
    }

    public void setCategories(categories categories) {
        this.categories = categories;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public void addInfo() throws SQLException {
        PreparedStatement a = connection.getConn().prepareStatement
                ("INSERT INTO film (film_name, category, Rate, votes, user_id, `describe`) " +
                        "VALUES (?,?,?,?,?,?);");
        a.setString(1,getName());
        a.setInt(2, getCategories().getRowid());
        a.setInt(3,0);
        a.setInt(4, 0);
        a.setInt(5, getDirector().getRowid());
        a.setString(6, getDescribing());
        a.executeUpdate();
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
        return false;
    }

    @Override
    public String getArtefact() {
        return null;
    }


}
