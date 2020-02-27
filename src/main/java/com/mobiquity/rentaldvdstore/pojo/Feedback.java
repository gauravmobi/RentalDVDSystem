package com.mobiquity.rentaldvdstore.pojo;

import javax.persistence.ManyToOne;
public class Feedback {
    @ManyToOne
    private Customer id;
    private String feedbackDescription;

    public Feedback() {
    }

    public Feedback(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }

    public Customer getId() {
        return id;
    }

    public void setId(Customer id) {
        this.id = id;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }
}
