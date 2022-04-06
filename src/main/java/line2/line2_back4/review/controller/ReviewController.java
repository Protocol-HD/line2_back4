package line2.line2_back4.review.controller;

import line2.line2_back4.review.model.ReviewDtoInput;
import line2.line2_back4.systemMessage.SystemMessage;

public interface ReviewController {
    SystemMessage add(ReviewDtoInput reviewDtoInput);

    SystemMessage edit(ReviewDtoInput reviewDtoInput);

    SystemMessage deleteById(Long id);
}
