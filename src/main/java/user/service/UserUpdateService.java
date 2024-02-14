package user.service;

import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.Scanner;

public class UserUpdateService implements UserService{
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = UserDAO.getInstance();
        System.out.print("찾을 아이디 입력 : ");
        String id = sc.nextLine();
        UserDTO userDTO = userDAO.selectUserById(id);

        if (userDTO == null) {
            System.out.println("찾는 아이디가 없습니다.");
            return;
        } else {
            System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
            System.out.print("수정할 이름 입력 : ");
            String name = sc.nextLine();
            userDTO.setName(name);
            System.out.print("수정할 비밀번호 입력 : ");
            String pwd = sc.nextLine();
            userDTO.setPwd(pwd);
        }

        userDAO.updateUser(userDTO);
        System.out.println("수정을 완료하였습니다.");
        System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
    }
}
