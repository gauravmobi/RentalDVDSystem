package com.mobiquity.rentaldvdstore.pojo;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Rental")
public class Rental extends MetadataPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rental_id;
    private String rental_date;
    @ManyToOne
    private Customer customer_id;
    private String return_date;
    @ManyToOne
    private Dvd dvdid;

    public Rental() {
    }

    public Dvd getDvdid() {
        return dvdid;
    }

    public void setDvdid(Dvd dvdid) {
        this.dvdid = dvdid;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public String getRental_date() {
        return rental_date;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}
