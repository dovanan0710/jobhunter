package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createNewUser(@RequestBody User postManUser) {/// truyền dữ liệu mới dùng requestbody

        User ericUser = this.userService.handleCreteUsser(postManUser);
        return ericUser;
    }

    @DeleteMapping("/user/{id}") // truyền độg tham số {}
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "ericusser";
    }

    @GetMapping("/user") // lấy tất cả user
    public List<User> getAllUser() {
        return userService.fetchAllUser();
    }

    @GetMapping("/user/{id}") // lấy 1 user
    public User getUserById(@PathVariable("id") long id) {

        return userService.fetchUserById(id);

    }

    @PutMapping("user")
    public User updatUser(@RequestBody User user) {
        User ericUser = this.userService.handleUpdateUser(user);
        return ericUser;
    }
    // công cụ viết nhanh CRUD spring data rest dùng cho dự án đơn giản

}
