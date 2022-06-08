package files.service;


import files.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
