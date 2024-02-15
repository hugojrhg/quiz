package com.hugo.quiz.service;

import com.hugo.quiz.builder.UserMapper;
import com.hugo.quiz.dto.UserDTO;
import com.hugo.quiz.exception.user.UserAlreadyExistsException;
import com.hugo.quiz.exception.user.UserNotFoundException;
import com.hugo.quiz.model.User;
import com.hugo.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserMapper userMapper;

    public UserDTO getUserById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    public UserDTO getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Not exist a user with this Email or Password"));

        if (verifyPassword(user.getPassword(), password)){
            return userMapper.toDTO(user);
        }else{
            throw new UserNotFoundException("Not exist a user with this Email or Password");
        }

    }

    public List<UserDTO> getAllUsers() {
        return userMapper.toListDTO(userRepository.findAll());
    }

    public UserDTO saveUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getId())){
            throw new UserAlreadyExistsException();
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(UserDTO newUser, Long id) {
        User oldUser = userMapper.toEntity(getUserById(id));
        oldUser.setName(newUser.getName());
        oldUser.setFullName(newUser.getFullName());
        oldUser.setAge(newUser.getAge());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userMapper.toDTO(userRepository.save(oldUser));
    }

    public Boolean verifyPassword(String encodedPassword, String password) {
        return passwordEncoder.matches(password, encodedPassword);
    }

}
