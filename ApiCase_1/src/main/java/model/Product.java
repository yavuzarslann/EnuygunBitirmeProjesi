package model;

import lombok.Data;

@Data
public class Product {
    public int id;
    public String name;
    public int price;
    public int stock;
}
