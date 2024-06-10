package com.n1kishin.program;

import com.n1kishin.repository.UserRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            UserRepository rep = new UserRepository("https://jsonplaceholder.typicode.com/users");
            System.out.println(rep);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}