package com.jfxbase.oopjfxbase.utils;

import java.time.LocalDate;

public class Account {

    private String Username;
    private String Password;
    private String Email;
    private LocalDate Birthdate;
    private int highScore;

    public void setUsername(String username) {
        Username = username;
    }

    public String getUsername() {
        return Username;
    }

    public void setPassword(String password){
        Password = password;
    }

    public String getPassword(){
        return Password;
    }

    public void setEmail(String email){
        Email = email;
    }

    public String getEmail(){
        return Email;
    }

    public void setBirthdate(LocalDate birthdate){
        Birthdate = birthdate;
    }

    public LocalDate getBirthdate(){
        return Birthdate;
    }

    public int getHighScore(){ return highScore; }

    public void setHighScore(int highScore) { this.highScore = highScore; }

    public boolean checkValid(){
        if(Username != null & Password != null & Email !=null & Birthdate != null)
            return true;
        else return false;
    }

}
