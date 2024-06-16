package org.example.hashCodeEquals;

import org.example.hashCodeEquals.entities.Client;

public class PersonalizedHashCodeAndEquals {
    public static void main(String[] args) {
        Client firstClient = new Client("Maria", "maria@gmail.com");
        Client secondClient = new Client("Alex", "alex@gmail.com");
        Client thirdClient = new Client("Maria", "maria@gmail.com");


        System.out.println(firstClient.hashCode());
        System.out.println(secondClient.hashCode());
        System.out.println(firstClient.equals(secondClient));
        System.out.println(firstClient.equals(thirdClient));
        System.out.println(firstClient == thirdClient);
    }
}
