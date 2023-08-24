package com.example.tripplanner.Service;


import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.Package;
import com.example.tripplanner.Model.RatingAndReview;
import com.example.tripplanner.Repository.PackageRepository;
import com.example.tripplanner.Repository.RatingAndReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RatingAndReviewService {

    private final RatingAndReviewRepository ratingAndReviewRepository;
    private final PackageRepository packageRepository;

    public List<RatingAndReview> getAllRatingAndReviews() {
        return ratingAndReviewRepository.findAll();
    }

    public void addRatingAndReviews(RatingAndReview ratingAndReview) {

        ratingAndReviewRepository.save(ratingAndReview);
    }

    public void updateRatingAndReviews(Integer id, RatingAndReview ratingAndReview) {
        RatingAndReview ratingAndReview1 = ratingAndReviewRepository.findRatingAndReviewById(id);
        if (ratingAndReview1 == null) {
            throw new ApiException("the review not found not found");
        }
        ratingAndReview1.setReview(ratingAndReview.getReview());
        ratingAndReview1.setRating(ratingAndReview.getRating());
        ratingAndReviewRepository.save(ratingAndReview1);
    }

    public void deleteRatingAndReviews(Integer id) {
        RatingAndReview ratingAndReview1 = ratingAndReviewRepository.findRatingAndReviewById(id);
        if (ratingAndReview1 == null) {
            throw new ApiException("the review not found not found");
        }
        ratingAndReviewRepository.delete(ratingAndReview1);

    }

    //Add Rating and review for specific Package
    public void userAddRatingAndReview(Integer package_id, RatingAndReview ratingAndReview1) {
        Package apackage = packageRepository.findPackageById(package_id);
        if (apackage == null) {
            throw new ApiException("the package not found");
        }
        RatingAndReview ratingAndReview=new RatingAndReview();
        ratingAndReview.setRating(ratingAndReview1.getRating());
        ratingAndReview.setReview(ratingAndReview1.getReview());
        ratingAndReview.setAPackage(apackage);
        ratingAndReviewRepository.save(ratingAndReview);
        calculatePackagesRating(package_id);
    }

    //calculate package rating
    public void calculatePackagesRating(Integer package_id )
    {
        int one=0,tow=0,three=0,four=0,five=0;
        for (int j=0;j<ratingAndReviewRepository.findAll().size();j++) {
            if (ratingAndReviewRepository.findAll().get(j).getAPackage().getId() == package_id) {
                Integer rate = ratingAndReviewRepository.findAll().get(j).getRating();
                if(rate!=null) {
                    if (rate == 1) {
                        one++;
                    } else if (rate == 2) {
                        tow++;
                    } else if (rate == 3) {
                        three++;
                    } else if (rate == 4) {
                        four++;
                    } else if (rate == 5) {
                        five++;
                    }
                }
            }
        }
              Integer arr[]={one,tow,three,four,five};
                Integer max = arr[1];
                Integer index=0;
               for (int m=0;m<arr.length;m++)
               {
                   if(arr[m]>max)
                   {
                       max=arr[m];
                       index=m;
                   }

               }
                Package apackage = packageRepository.findPackageById(package_id);
                apackage.setPackageRate(index+1);
                packageRepository.save(apackage);
            }

    //get all packages and its rating with from high  to low
    public  List<Package> getAllPackagesWithRatingFromHighToLow() {
        List<Package> packages=packageRepository.findAll();
        Collections.sort(packages, Comparator.comparing(Package::getPackageRate));
        List<Package>orderedPackages=new ArrayList<>();
        for(int i = packages.size()-1;i>=0; i--){
            orderedPackages.add(packages.get(i));
        }
        return orderedPackages;
    }

    //get Rating and review for specific Package
    public Package getReviewAndOfSpecificPackage(Integer package_id)
    {
        return packageRepository.findPackageById(package_id);
    }
}






