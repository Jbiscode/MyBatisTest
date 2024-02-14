package user.service;

import user.dao.UserDAO;

import java.util.Scanner;

public class UserDeleteService implements UserService{
    @Override
    public void execute() {
        UserDAO userDAO = UserDAO.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.print("찾고자 하는 아이디 입력 : ");
        String id = sc.nextLine();
        if (userDAO.selectUserById(id) == null) {
            System.out.println("찾는 아이디가 없습니다.");
        } else {
            userDAO.deleteUser(id);
            System.out.println("회원정보를 삭제하였습니다.");
        }
    }
}
