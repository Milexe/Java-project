package by.savin.comprent.service;

import by.savin.comprent.dto.UserDto;
import by.savin.comprent.entity.User;
import by.savin.comprent.exceptions.IncorrectPasswordException;
import by.savin.comprent.exceptions.UserNameNotFoundException;

public interface UserService {
    User login(UserDto userDto) throws UserNameNotFoundException, IncorrectPasswordException;
    void register(UserDto userDto) throws Exception;
    boolean isAdmin(String username);
    User getUserByUsername(String username);
}
