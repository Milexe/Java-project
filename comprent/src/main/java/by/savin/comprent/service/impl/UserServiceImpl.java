package by.savin.comprent.service.impl;

import by.savin.comprent.aspect.*;
import by.savin.comprent.entity.ItemEntity;
import by.savin.comprent.repository.RoleRepository;
import by.savin.comprent.repository.UserRepository;
import by.savin.comprent.config.Mapper;
import by.savin.comprent.dto.UserDto;
import by.savin.comprent.entity.User;
import by.savin.comprent.exceptions.IncorrectPasswordException;
import by.savin.comprent.exceptions.UserNameNotFoundException;
import by.savin.comprent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) throws IOException {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    @Loggable
    public User login(UserDto userDto) throws UserNameNotFoundException, IncorrectPasswordException {
        User user = Mapper.map(userDto, User.class);
        //log.info("Call method  login");
        user.setUsername(user.getUsername().toLowerCase());
        User possibleUser = userRepository
                .findUserByUsername(userDto
                        .getUsername())
                .orElseThrow(()->new UserNameNotFoundException("User not found"));
        if(!passwordEncoder.matches(userDto.getPassword(), possibleUser.getPassword())) throw new IncorrectPasswordException("Incorrect password");








        return possibleUser;
    }

    @Override
    @Loggable
    public void register(UserDto userDto) throws Exception {
        if(userRepository
                .findUserByUsername(userDto.getUsername())
                .isPresent()) throw new Exception("User has already registered");

        if(!userDto
                .getPassword()
                .equals(userDto
                        .getRepeatPassword())){
            throw new Exception("Passwords are not equal");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        //log.info("Call method  register");
        user.setRole(roleRepository.getRoleByName("USER"));
        userRepository.save(user);
    }

    @Override
    @Loggable
    public boolean isAdmin(String username) {
        return userRepository.findUserByUsername(username)
                .get()
                .getRole()
                .getName()
                .equals("ADMIN");
    }

    @Override
    @Loggable
    public User getUserByUsername(String username) {
        return userRepository
                .findUserByUsername(username)
                .get();
    }

//    public void updateUser(User entity){
//        userRepository.deleteById(entity.getId());
//        userRepository.save(entity);
//
//    }
}
