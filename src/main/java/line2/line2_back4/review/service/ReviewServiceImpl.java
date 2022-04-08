package line2.line2_back4.review.service;

import line2.line2_back4.restApi.RestApiService;
import line2.line2_back4.review.model.Review;
import line2.line2_back4.review.model.ReviewDto;
import line2.line2_back4.review.repository.ReviewRepository;
import line2.line2_back4.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestApiService restApiService;

    @Override
    public SystemMessage add(ReviewDto reviewDtoInput) {
        try {
            log.info("ReviewService add Review({}) start", reviewDtoInput);
            reviewRepository.save(Review.builder()
                    .id(reviewDtoInput.getReviewId())
                    .review(reviewDtoInput.getReview())
                    .star(reviewDtoInput.getStar())
                    .home(restApiService.getHomeById(reviewDtoInput.getHomeId()))
                    .user(restApiService.getUserById(reviewDtoInput.getUserId()))
                    .build());
            return SystemMessage.builder()
                    .code(1)
                    .message("리뷰 등록 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReviewService add Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 등록 실패")
                    .build();
        } finally {
            log.info("ReviewService add Review end");
        }
    }

    @Override
    public SystemMessage edit(ReviewDto reviewDtoInput) {
        try {
            log.info("ReviewService edit Review({}) start", reviewDtoInput);
            reviewRepository.save(Review.builder()
                    .id(reviewDtoInput.getReviewId())
                    .review(reviewDtoInput.getReview())
                    .star(reviewDtoInput.getStar())
                    .home(restApiService.getHomeById(reviewDtoInput.getHomeId()))
                    .user(restApiService.getUserById(reviewDtoInput.getUserId()))
                    .build());
            return SystemMessage.builder()
                    .code(1)
                    .message("리뷰 수정 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReviewService edit Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 수정 실패")
                    .build();
        } finally {
            log.info("ReviewService edit Review end");
        }
    }

    @Override
    public SystemMessage deleteById(Long id) {
        try {
            log.info("ReviewService delete by id Review(id: {}) start", id);
            reviewRepository.deleteById(id);
            return SystemMessage.builder()
                    .code(1)
                    .message("리뷰 삭제 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReviewService delete by id Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 삭제 실패")
                    .build();
        } finally {
            log.info("ReviewService delete by id Review end");
        }
    }

    @Override
    public List<ReviewDto> findbyHomeId(Long id) {
        try {
            log.info("ReviewService find by home id Reviews(id: {}) start", id);
            List<ReviewDto> reviews = new ArrayList<ReviewDto>();
            reviewRepository.findByHomeId(id).forEach(review -> {
                reviews.add(ReviewDto.builder()
                        .reviewId(review.getId())
                        .review(review.getReview())
                        .star(review.getStar())
                        .homeId(review.getHome().getId())
                        .userId(review.getUser().getId())
                        .build());
            });
            return reviews;
        } catch (Exception e) {
            log.error("ReviewService find by home id Reviews failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReviewService find by home id Reviews end");
        }
    }

    @Override
    public List<ReviewDto> findByUserId(Long id) {
        try {
            log.info("ReviewService find by user id Reviews(id: {}) start", id);
            List<ReviewDto> reviews = new ArrayList<ReviewDto>();
            reviewRepository.findByUserId(id).forEach(review -> {
                reviews.add(ReviewDto.builder()
                        .reviewId(review.getId())
                        .review(review.getReview())
                        .star(review.getStar())
                        .homeId(review.getHome().getId())
                        .userId(review.getUser().getId())
                        .build());
            });
            return reviews;
        } catch (Exception e) {
            log.error("ReviewService find by user id Reviews failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReviewService find by user id Reviews end");
        }
    }
}
