package in.hangang.controller;

import in.hangang.annotation.Auth;
import in.hangang.domain.Review;
import in.hangang.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
public class ReviewController {

    @Resource
    ReviewService reviewService;

    @Auth
    @ApiOperation( value = "" , authorizations = @Authorization(value = "Bearer +accessToken"))
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ResponseEntity createReview(@RequestBody Review review) throws Exception {
        reviewService.createReview(review);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ResponseEntity getReviewList() throws Exception {
        return new ResponseEntity<ArrayList<Review>>(reviewService.getReviewList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/review/{id}", method = RequestMethod.GET)
    public ResponseEntity getReview(@PathVariable Long id) throws Exception{
        return new ResponseEntity<Review>(reviewService.getReview(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/review/{id}", method = RequestMethod.POST)
    public ResponseEntity createLikesReview(@PathVariable Long id) throws Exception{
        reviewService.createLikesReview(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/review/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteReview(@PathVariable Long id) throws Exception{
        reviewService.deleteReviewById(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
