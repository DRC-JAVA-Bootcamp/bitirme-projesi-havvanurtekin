package com.example.kodluyoruzbitirmewbs.service;

import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.entity.UserRole;
import com.example.kodluyoruzbitirmewbs.repository.UserRepository;
import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int saveUser(UserSaveRequestDto userSaveRequestDto) {
    String nameRequestDto = userSaveRequestDto.getName();
    String surnameRequestDto = userSaveRequestDto.getSurname();
    String emailRequestDto = userSaveRequestDto.getEmail();
    UserRole roleRequestDto = userSaveRequestDto.getRole();
    User user = new User();

    user.setName(nameRequestDto);
    user.setSurname(surnameRequestDto);
    user.setEmail(emailRequestDto);
    user.setRole(roleRequestDto);

    user = userRepository.save(user);

    return user.getId();
    }
}
