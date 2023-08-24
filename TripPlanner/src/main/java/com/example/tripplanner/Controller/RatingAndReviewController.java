package com.example.tripplanner.Controller;

import com.example.tripplanner.Model.RatingAndReview;
import com.example.tripplanner.Service.RatingAndReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/review")
public class RatingAndReviewController {
    private final RatingAndReviewService ratingAndReviewService;

    @GetMapping("/get")
    public ResponseEntity getAllRatingAndReviews() {
        return ResponseEntity.status(200).body(ratingAndReviewService.getAllRatingAndReviews());
    }

    @PostMapping("/add")
    public ResponseEntity addRatingAndReview(@Valid @RequestBody RatingAndReview ratingAndReview) {
        ratingAndReviewService.addRatingAndReviews(ratingAndReview);
        return ResponseEntity.status(200).body("The Rating And Review is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRatingAndReview(@PathVariable Integer id, @Valid @RequestBody RatingAndReview ratingAndReview) {
        ratingAndReviewService.updateRatingAndReviews(id, ratingAndReview);
        return ResponseEntity.status(200).body("The Rating And Review is updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRatingAndReview(@PathVariable Integer id) {
        ratingAndReviewService.deleteRatingAndReviews(id);
        return ResponseEntity.status(200).body("The Rating And Review is deleted");
    }
    //--------------------------------------------------------------------------------
    //Add Rating and review for specific Package
    @PostMapping("/addreview/{package_id}")
    public ResponseEntity userAddRatingAndReview(@PathVariable Integer package_id, @Valid @RequestBody RatingAndReview ratingAndReview) {
        ratingAndReviewService.userAddRatingAndReview(package_id,ratingAndReview);
        return ResponseEntity.status(200).body("The Rating And Review is added");
    }

    //get All Packages with sorting by rating in DESN order
    @GetMapping("/getpackagedesn")
    public ResponseEntity  getAllPackagesWithRatingFromHighToLow(){
     return ResponseEntity.status(200).body(ratingAndReviewService.getAllPackagesWithRatingFromHighToLow());
    }
    //get Rating and review for specific Package
    @GetMapping("/getpackage/{package_id}")
    public ResponseEntity  getReviewOfSpecificPackage(@PathVariable Integer package_id){
        return ResponseEntity.status(200).body(ratingAndReviewService.getReviewAndOfSpecificPackage(package_id));
    }

}




