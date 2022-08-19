package model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Pets {
    private String id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;
}
