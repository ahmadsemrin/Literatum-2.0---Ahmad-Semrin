package web_app_design.model.data_access_object.user;

import web_app_design.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> findAll();
    User findByEmail(String email);
    void insertUser(User user);
}
