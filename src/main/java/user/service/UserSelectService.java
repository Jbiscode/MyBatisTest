package user.service;

import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.List;

public class UserSelectService implements UserService {
    @Override
    public void execute() {
        UserDAO userDAO = UserDAO.getInstance();
        List<UserDTO> userDTOS = userDAO.selectAllUsers();
        for (UserDTO userDTO : userDTOS) {
            System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
        }
    }
}
