package ru.restoraunt.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;


@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rowid;

    @Column(name = "name")
    private String name;

    @Column(name = "Image")
    private byte[] image;

    private double price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = true)
    private Date createDate;

    public Goods() {
        createDate = new Date();
    }

    public Goods(String name, byte[] image, double price) {
        this();
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public int getRowid() {
        return rowid;
    }

    public void setRowid(int rowid) {
        this.rowid = rowid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "rowid=" + rowid +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", price=" + price +
                ", createDate=" + createDate +
                '}';
    }
}
