package com.example.osama.volley.Models;

/**
 * Created by osama on 10/28/2017.
 */

public class Contact {
    private String name,email,id;

    public Contact(String name, String email, String id) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
