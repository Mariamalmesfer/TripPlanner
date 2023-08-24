package com.example.tripplanner.Repository;

import com.example.tripplanner.Model.Plan;
import com.example.tripplanner.Model.RatingAndReview;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.naming.ldap.SortKey;
import java.util.List;

public interface RatingAndReviewRepository extends JpaRepository<RatingAndReview,Integer> {
    RatingAndReview findRatingAndReviewById(Integer id);

}
