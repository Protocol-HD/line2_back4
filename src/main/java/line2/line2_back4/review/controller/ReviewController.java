package line2.line2_back4.review.controller;

import java.util.List;

import line2.line2_back4.review.model.ReviewDto;
import line2.line2_back4.systemMessage.SystemMessage;

public interface ReviewController {
    SystemMessage add(ReviewDto reviewDtoInput);

    SystemMessage edit(ReviewDto reviewDtoInput);

    SystemMessage deleteById(Long id);

    List<ReviewDto> findbyHomeId(Long id);

    List<ReviewDto> findByUserId(Long id);
}
