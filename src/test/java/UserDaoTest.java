import com.kuang.dao.UserDao;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author Huang.learning 2022/3/19 11:11
 */
public class UserDaoTest {
    @Test
    public void test()  {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();

//        List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int haha = mapper.addUser(new User(4, "haha", "123333"));
        if(haha > 0){
            System.out.println("added an user successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int hehe = mapper.updateUser(new User(4, "hehe", "123123"));
        if(hehe>0){
            System.out.println("update an user successfully.");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void removeUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.removeUser(4);
        if(i>0){
            System.out.println("remove an user successfully.");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
