package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.test.DTO.*;
import com.example.test.Service.UserService;
import com.example.test.Service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/findAllUser")
    public List<User> login() {
        return userService.FindAllUser();
    }

    @JsonView(View.userShownData.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    User login(@RequestBody User user) {
        User userout = userService.findUserByUsername(user.getUserName());
        return userout;
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public @ResponseBody
    User loginCheck(@RequestBody User user) {
        return userService.findUserByUsername(user.getUserName());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseMsg register(@RequestBody @JsonView(View.Register.class) User registeredUser) {
        Boolean isReject = registeredUser.isReject();
        ResponseMsg response = new ResponseMsg();
        boolean dupe = userService.hasMatchedUsername(registeredUser.getUserName());
        if (dupe) {
            ErrorAPI error = new ErrorAPI();
            error.setErrorCode(10);
            error.setErrorMsg("Duplicated Username");
            response.setError(error);
            response.setResponseMsg("Error");
        } else if (!isReject) {
            if (userService.RegisterUser(registeredUser)) {
                response.setResponseMsg("register success");
            } else {
                response.setResponseMsg("register success");
            }
        } else {
            ErrorAPI error = new ErrorAPI();
            error.setErrorCode(20);
            error.setErrorMsg("salary less than 15000");
            response.setResponseMsg("Error");
            response.setError(error);
        }
        return response;
    }

}
