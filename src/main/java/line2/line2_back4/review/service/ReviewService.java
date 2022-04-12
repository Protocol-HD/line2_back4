package line2.line2_back4.review.service;

import java.util.List;

import line2.line2_back4.review.model.Review;
import line2.line2_back4.systemMessage.SystemMessage;

public interface ReviewService {
    SystemMessage add(Review review);

    SystemMessage edit(Review review);

    SystemMessage deleteById(Long id);

    List<Review> findbyHomeId(Long id);

    List<Review> findByUserId(Long id);
}
