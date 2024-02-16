package user.service;

import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserSearchService implements UserService {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("***************");
        System.out.println("   1. 이름검색  ");
        System.out.println("   2. 아이디검색");
        System.out.println("***************");
        System.out.print("검색 방법을 선택하세요 : ");
        int num = sc.nextInt();

        Map<String, String> map = new HashMap<>();
        String colName="";
        String value="";

        if (num == 1) {
            System.out.print("검색할 이름을 입력하세요 : ");
            colName = "name";
            value = sc.next();
            System.out.println(value + "님의 정보를 출력합니다.");
        } else if (num == 2) {
            System.out.print("검색할 아이디를 입력하세요 : ");
            colName = "id";
            value = sc.next();
            System.out.println(value + "님의 정보를 출력합니다.");
        }

        map.put("colName", colName);
        map.put("value", value);


        UserDAO userDAO = UserDAO.getInstance();
        List<UserDTO> list = userDAO.search(map);

        for (UserDTO userDTO : list) {
            System.out.print(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd() + '\n');
        }
    }


}
