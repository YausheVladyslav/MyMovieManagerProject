package com.example.moviemanager.controllers;

import com.example.moviemanager.requests.EditPasswordRequest;
import com.example.moviemanager.requests.LoginRequest;
import com.example.moviemanager.requests.RegisterUserRequest;
import com.example.moviemanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String home() {
        return "home page";
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registration(@Valid @RequestBody RegisterUserRequest request) {
        userService.saveUser(
                request.getFirstName(),
                request.getSecondName(),
                request.getNickname(),
                request.getPassword(),
                request.getRepeatPassword()
        );
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request) {
        userService.login(request.getLogin(), request.getPassword());
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/edit-password")
    public ResponseEntity<Void> editPassword(
            @PathVariable long id,
            @RequestBody EditPasswordRequest editRequest){
        userService.editPassword(
                id,
                editRequest.getOldPassword(),
                editRequest.getNewPassword(),
                editRequest.getRepeatNewPassword()
        );
        return ResponseEntity.ok().build();
    }
}
