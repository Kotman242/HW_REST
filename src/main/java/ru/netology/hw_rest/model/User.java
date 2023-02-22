package ru.netology.hw_rest.model;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private String user;

    private String password;

    private Authorities[] authorities;
    private static final Authorities[] DEFAULT_AUTHORITIES = {Authorities.READ,Authorities.WRITE};

    public User(String user, String password, Authorities...authorities) {
        this.user = user;
        this.password = password;
        if(authorities.length==0) this.authorities= DEFAULT_AUTHORITIES;
        else this.authorities=authorities;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authorities[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Authorities[] authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "CommonUser{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + Arrays.toString(authorities) +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(user, that.user) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    public User() {
    }
}
