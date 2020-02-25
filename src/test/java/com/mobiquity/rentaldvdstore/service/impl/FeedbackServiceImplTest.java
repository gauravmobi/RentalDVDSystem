package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.FeedbackDao;
import com.mobiquity.rentaldvdstore.pojo.Feedback;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class FeedbackServiceImplTest {
    FeedbackServiceImpl feedbackService = new FeedbackServiceImpl();
    @Mock
    FeedbackDao feedbackDao;

    Feedback feedback;

    @Before
    public void setup(){
        feedbackService.setFeedbackDao(feedbackDao);
    }

    @Test
    public void testAddFeedback() {
        feedback = new Feedback("Very Good Site");
        Mockito.when(feedbackDao.addFeedback(feedback)).thenReturn("Feedback Recieved");
        assertEquals("Feedback Recieved",feedbackService.addFeedback(feedback));
    }
    @Test()
    public void testForExceptionInAddFeedback() {
        feedback = new Feedback("Very Good Site");
        Mockito.when(feedbackDao.addFeedback(feedback)).thenThrow(RuntimeException.class);
        assertEquals("Feedback Not Recieved",feedbackService.addFeedback(feedback));
    }


    /**
     * The feedback object is null
     */
    @Test(expected = NullPointerException.class)
    public void testForNullFeedback() {
        feedbackService.addFeedback(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullFeedbackDescription() {
        feedback.setFeedbackDescription(null);
        feedbackService.addFeedback(feedback);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyFeedbackDescription() {
        feedback.setFeedbackDescription("");
        feedbackService.addFeedback(feedback);
    }

    @Test
    public void testAddFeedbackWhenFeedbackDaoReturnsNull() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackDescription("Description");
        Mockito.when(feedbackDao.addFeedback(feedback)).thenReturn(null);
        assertEquals("Feedback Not Recieved", feedbackService.addFeedback(feedback));
    }

}