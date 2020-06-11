package com.test.RedisDemo.entry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    public User() {
        super();
    }

    public User(String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }

}