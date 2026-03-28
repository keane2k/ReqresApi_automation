package models;

import lombok.Data;

@Data // creates getters and setters automaticly
public class UserModel {
    private String name;
    private String job;
}