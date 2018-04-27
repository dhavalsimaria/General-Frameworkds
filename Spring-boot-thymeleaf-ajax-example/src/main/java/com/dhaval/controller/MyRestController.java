/**
 * 
 */
package com.dhaval.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhaval.model.AjaxResponseBody;
import com.dhaval.model.LoginForm;
import com.dhaval.model.User;
import com.dhaval.services.UserService;

/**
 * @author Dhaval Simaria
 *
 */
@RestController
public class MyRestController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody LoginForm loginForm, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest()
                .body(result);

        }

        List<User> users = userService.login(loginForm);
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }
}
