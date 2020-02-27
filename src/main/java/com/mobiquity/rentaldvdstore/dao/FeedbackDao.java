package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Feedback;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDao {
    public String addFeedback(Feedback feedback);
}
