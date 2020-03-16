package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.FeedbackDao;
import com.mobiquity.rentaldvdstore.pojo.Feedback;
import com.mobiquity.rentaldvdstore.service.FeedbackService;

public class    FeedbackServiceImpl implements FeedbackService {

    FeedbackDao feedbackDao;

    public void setFeedbackDao(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @Override
    public String addFeedback(Feedback feedback) {
        if (feedback != null && feedback.getFeedbackDescription() != null && !feedback.getFeedbackDescription().isEmpty()) {
            try {
                if (null != feedbackDao.addFeedback(feedback)) {
                    return "Feedback Recieved";
                } else {
                    return "Feedback Not Recieved";
                }
            } catch (Exception e) {
                return "Feedback Not Recieved";
            }
        } else {
            throw new NullPointerException("feedback should not be blank");
        }
    }
}