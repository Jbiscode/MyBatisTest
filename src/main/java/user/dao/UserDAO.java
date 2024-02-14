package user.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import user.bean.UserDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDAO {
    private static UserDAO userDAO = new UserDAO();
    private SqlSessionFactory sqlSessionFactory;


    public UserDAO() {
        try {
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDAO getInstance() {
        return userDAO;
    }

    public void insertUser(UserDTO userDTO) {
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("userSQL.insertUser", userDTO);
        session.commit();
    }

    public List<UserDTO> selectAllUsers() {
        SqlSession session = sqlSessionFactory.openSession();
        List<UserDTO> userDTO = session.selectList("userSQL.selectAllUsers");
        session.close();
        return userDTO;
    }
    public UserDTO selectUserById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        UserDTO userDTO = session.selectOne("userSQL.selectUserById", id);
        session.close();
        return userDTO;
    }

    public void updateUser(UserDTO userDTO) {
        SqlSession session = sqlSessionFactory.openSession();
        session.update("userSQL.updateUser", userDTO);
        session.commit();
        session.close();
    }

    public void deleteUser(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("userSQL.deleteUser", id);
        session.commit();
        session.close();
    }


}
