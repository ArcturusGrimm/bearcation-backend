package bearcation.model;

import org.junit.jupiter.api.*;

import bearcation.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Nested
@DisplayName("Review Tests")
public class ReviewTests {
/*
    @Test
    @DisplayName("Review Constructor Good Values")
    public void testRevConstructor() {
        Double rate = 5.0;

        String desc = "blue";

        List<String> answers = new ArrayList<String>();
        answers.add("testString");
        Survey s = new Survey(answers);

        Review r = new Review(rate, desc, answers);

        assertEquals(rate, r.getRating());
        assertEquals(desc, r.getDescription());
        assertEquals(s.getAnswerList(), r.getSurvey().getAnswerList());
    }

    @Test
    @DisplayName("Review Constructor Null description")
    public void testRevNullConstructor() {
        Double rate = 4.1;

        String desc = null;

        List<String> answers = new ArrayList<String>();
        answers.add("testString");
        Survey s = new Survey(answers);

        assertThrows(NullPointerException.class,
                () -> {Review r = new Review(rate, desc, answers);});
    }

    @Test
    @DisplayName("Set rating invalid values")
    public void setRatingTest() {
        Double rate = 4.1;

        String desc = "park123";

        List<String> answers = new ArrayList<String>();
        answers.add("testString");
        Survey s = new Survey(answers);
        Review r = new Review(rate, desc, answers);

        assertThrows(NullPointerException.class, () -> r.setRating(null));
        assertThrows(IllegalArgumentException.class, () -> r.setRating(-0.1));
        assertThrows(IllegalArgumentException.class, () -> r.setRating(5.1));
    }

    @Test
    @DisplayName("Set Description Null")
    public void setDescriptionTestNull() {
        Double rate = 4.1;

        String desc = "park123";

        List<String> answers = new ArrayList<String>();
        answers.add("testString");
        Survey s = new Survey(answers);
        Review r = new Review(rate, desc, answers);

        assertThrows(NullPointerException.class, () -> {r.setDescription(null);});
    }

 */
}
