package org.example;

import org.example.entities.Comment;
import org.example.entities.Post;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exercise02 {
    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Post post01 = new Post(dateFormat.parse("21/06/2018 13:05:44"), "Traveling to New Zealeand", "I'm going to visit this wonderful country", 12);
        Post post02 = new Post(dateFormat.parse("26/07/2018 23:14:19"), "Good night guys", "See you tomorrow", 5);
        post01.addComment(new Comment("Have a nice trip"));
        post01.addComment(new Comment("Wow that's awesome"));
        post02.addComment(new Comment("Good night"));
        post02.addComment(new Comment("May the force with you"));

        System.out.println(post01);
        System.out.println(post02);
    }
}
