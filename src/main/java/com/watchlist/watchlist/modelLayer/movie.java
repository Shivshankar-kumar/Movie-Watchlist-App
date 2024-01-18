package com.watchlist.watchlist.modelLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class movie {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Please! write the movie name")
    private String title;
    @Min (message = "Minimum rating 1 but less than 10", value = 1)
    @Max(message = "Minimum rating 1 but less than 10", value = 10)
    private float rating;
    @NotBlank(message = "Type the priority of movie [Low/Medium/High]")
    private String priority;
    @Size(min = 10, max = 50, message = "Minimum 10 character and maximum 50 chars is acceptable")
    private String comment;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}