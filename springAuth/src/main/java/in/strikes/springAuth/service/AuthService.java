package in.strikes.springAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.strikes.springAuth.dto.UserRegisterRequestDto;
import in.strikes.springAuth.dto.UserRegisterResponseDto;
import in.strikes.springAuth.entity.User;
import in.strikes.springAuth.repository.UserRepository;

@Service 
public class AuthService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto registerUser(UserRegisterRequestDto userRegisterRequestDto){
        User user = new User();
        user.setUserName(userRegisterRequestDto.getUsername());
        String encodedPasswrod = passwordEncoder.encode(userRegisterRequestDto.getPassword());

        user.setPassword(encodedPasswrod);
        user.setEnabled(true);

        userRepository.save(user);

          UserRegisterResponseDto responseDto = new UserRegisterResponseDto();

        responseDto.setUsername(user.getUserName());
        responseDto.setMessage("User saved Successfully");

        return responseDto;

    }
    


}
