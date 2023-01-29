package com.dariuszboc.bookshop.service;

import com.dariuszboc.bookshop.DTO.PasswordDTO;
import com.dariuszboc.bookshop.DTO.UserDTO;
import com.dariuszboc.bookshop.entity.User;
import com.dariuszboc.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return getDtoListFromUserList(users);
    }

    public void save(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRole("USER");
        userRepository.save(user);
    }

    public void saveWithNewPassword(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFullName(userDTO.getFullName());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRole("USER");
        userRepository.save(user);
    }

    public UserDTO findById(Long id) {
        User user =  userRepository.findById(id).get();
        return getUserDTOFromUser(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO findByUsername(String name) {
        User user = userRepository.findByUsername(name);
        return getUserDTOFromUser(user);
    }

    private UserDTO getUserDTOFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFullName(user.getFullName());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        return userDTO;
    }


    private List<UserDTO> getDtoListFromUserList(List<User> users) {
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> {
            Long id = user.getId();
            UserDTO userDTO = this.findById(id);
            usersDTO.add(userDTO);
        });
        return usersDTO;
    }

    public boolean processPassword(PasswordDTO passwordDTO, UserDTO userDTO) {
//        boolean condition1 = passwordEncoder.encode(passwordDTO.getOldPassword()).equals(userDTO.getPassword());
        boolean condition2 = passwordDTO.getNewPassword1().equals(passwordDTO.getNewPassword2());
        if (condition2) {
            userDTO.setPassword(passwordDTO.getNewPassword1());
            this.saveWithNewPassword(userDTO);
            return true;
        }
        return false;

    }
}

