package com.devrezaur.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devrezaur.main.model.Course;
import com.devrezaur.main.model.Payment;
import com.devrezaur.main.model.Post;
import com.devrezaur.main.service.CourseService;
import com.devrezaur.main.service.PaymentService;
import com.devrezaur.main.service.PostService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/{courseId}/getPost")
	public List<Post> getPost(@PathVariable("courseId") int courseId) {
		return postService.getPosts(courseId);
	}
	
	@GetMapping("/{userId}/getCourses")
	public List<Course> getEnrolledCourses(@PathVariable("userId") int userId) {
		return courseService.getEnrolledCourse(userId);
	}
	
	@PostMapping("/pay")
	public Payment pay(@RequestBody Payment payment) {
		return paymentService.pay(payment);
	}
}
