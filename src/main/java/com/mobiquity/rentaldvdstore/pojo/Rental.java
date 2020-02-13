package com.mobiquity.rentaldvdstore.pojo;

import java.util.Date;

public class Rental extends MetadataPojo
{
    private int rental_id;
    private Date rental_date;
    private int inventory_id;
    private int customer_id;
    private Date return_date;
}
