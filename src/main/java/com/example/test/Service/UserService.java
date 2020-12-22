package com.example.test.Service;
import com.example.test.DTO.*;
import java.util.List;

public interface UserService {
    public abstract Boolean RegisterUser(User user);
    public abstract User findUserByUsername(String userName);
    public abstract List<User> FindAllUser();
    public abstract boolean hasMatchedUsername(String username);
 }
 