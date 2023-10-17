package org.example.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private Date moment;
    private String title;
    private String content;
    private Integer likes = 0;
    private List<Comment> comments = new ArrayList<>();

    public Post(Date moment, String title, String content, int likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.title).append("\n");
        stringBuilder.append(this.likes).append(" Likes - ").append(dateFormat.format(this.moment)).append("\n");
        stringBuilder.append(this.content).append("\n");
        stringBuilder.append("Comments:").append("\n");
        for (Comment comment : this.comments) {
            stringBuilder.append(comment.getComment()).append("\n");
        }
        return stringBuilder.toString();
    }
}
