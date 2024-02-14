package user.service;


import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.Scanner;

public class UserInsertService implements UserService {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.println("등록을 선택하셨습니다.");

        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("아이디 입력 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 입력 : ");
        String pwd = sc.nextLine();

        UserDTO userDTO = UserDTO.builder()
                                 .name(name)
                                 .id(id)
                                 .pwd(pwd)
                                 .build();

        UserDAO userDAO = UserDAO.getInstance();
        userDAO.insertUser(userDTO);

        System.out.println("데이터를 등록하였습니다.");
    }
}
