package org.boeing.cm.cotsdb.service;

import org.boeing.cm.cotsdb.model.User;
import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}