package codegym.service;

import codegym.model.User;

import java.util.ArrayList;

public interface IUserService {
    ArrayList<User> findAll();
    User findById(long id);
}
