package in.strikes.springAuth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.strikes.springAuth.dto.UserRegisterRequestDto;
import in.strikes.springAuth.dto.UserRegisterResponseDto;
import in.strikes.springAuth.service.AuthService;

@RestController 
@RequestMapping("/api/v1")
public class RootControllers{

    private AuthService authService;

    public RootControllers(AuthService authService){
        this.authService = authService;
    }

    @GetMapping ("/users")
    public void users(){
        System.out.println("Users");
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> registerUser(@RequestBody UserRegisterRequestDto userRegisterRequestDto){
        System.out.println("User Register");
        UserRegisterResponseDto userRegisterResponseDto = authService.registerUser(userRegisterRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }

}