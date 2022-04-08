package line2.line2_back4.review.repository;

import line2.line2_back4.review.model.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHomeId(Long id);
    
    List<Review> findByUserId(Long id);
}
