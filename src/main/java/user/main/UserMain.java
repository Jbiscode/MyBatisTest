package user.main;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

import java.util.Scanner;

public class UserMain {
    UserService userService;

    public void menu(){
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            System.out.println(("""
                    ************
                       1. 등록
                       2. 출력
                       3. 수정
                       4. 삭제
                       5. 검색
                       6. 종료
                    ************
                    """));
            System.out.print("메뉴를 선택하세요 : ");
            num = sc.nextInt();

            switch (num) {
                case 1 -> userService = new UserInsertService();
                case 2 -> userService = new UserSelectService();
                case 3 -> userService = new UserUpdateService();
                case 4 -> userService = new UserDeleteService();
                case 5 -> userService = new UserSearchService();
                case 6 -> {
                    System.out.println("종료합니다.");
                    sc.close();
                    return;
                }
            }
            userService.execute();
        }
    }
    public static void main(String[] args) {
        UserMain userMain = new UserMain();
        userMain.menu();
    }
}
