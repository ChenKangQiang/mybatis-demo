import edu.tongji.comm.spring.demo.entity.User;
import edu.tongji.comm.spring.demo.dao.UserDAO;
import edu.tongji.comm.spring.demo.dao.UserDAOWithAnnotation;
import edu.tongji.comm.spring.demo.services.UserService;
import edu.tongji.comm.typical.demo.utils.RandomUtil;
import org.apache.commons.lang3.Validate;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by chen on 2017/6/29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class MybatisSpringTest {

    // 注入sqlSessionFactory
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    // 直接注入数据映射器
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserDAOWithAnnotation userDAOWithAnnotation;

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {

        // 直接利用sqlSessionFactory
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userMapper = sqlSession.getMapper(UserDAO.class);
        User user = userMapper.getUserById(1);

        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testGetUserById2() {

        // 直接利用userMapper
        User user2 = userDAO.getUserById(2);
        User user3 = userDAOWithAnnotation.getUserById(3);
        System.out.println(user2);
        System.out.println(user3);

    }


    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0 ; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String username = RandomUtil.getRandomString(10);
                    String password = RandomUtil.getRandomString(10);
                    String email = username + "@dianping.com";

                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);

                    int effectrow = userDAO.addUser(user); // 成功为1
                    //打印刚插入的记录的Id
                    System.out.println(user.getId());
                    System.out.println(effectrow);
                    users.add(user);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testInsertIgnore() {
        String password = RandomUtil.getRandomString(10);

        User user = new User();
        user.setUsername("Zhangshan");
        user.setPassword(password);
        user.setEmail("zhangshan@dianping.com");


        int effectrow = userDAO.addUser(user);
        System.out.println(effectrow);
        System.out.println(user.getId());
    }

    @Test
    public void testInsertIgnoreNew() {
        String password = RandomUtil.getRandomString(10);

        User user = new User();
        user.setUsername("Zhangshan");
        user.setPassword(password);
        user.setEmail("zhangshan@dianping.com");

        try {
            int effectrow = userDAO.addUser(user);
            System.out.println(effectrow);
            System.out.println(user.getId());
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertUser1() {
        List<User> users = new ArrayList<>();
        for (int i = 0 ; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String username = RandomUtil.getRandomString(10);
                    String password = RandomUtil.getRandomString(10);
                    String email = username + "@dianping.com";

                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);

                    int effectrow = userDAO.addUser(user); // 成功为1
                    //打印刚插入的记录的Id
                    System.out.println(user.getId());
                    System.out.println(effectrow);
                    users.add(user);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testInsertUser2() {
        List<User> users = new ArrayList<>();
        for (int i = 0 ; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String username = RandomUtil.getRandomString(10);
                    String password = RandomUtil.getRandomString(10);
                    String email = username + "@dianping.com";

                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);

                    int effectrow = userDAO.addUser(user); // 成功为1
                    //打印刚插入的记录的Id
                    System.out.println(user.getId());
                    System.out.println(effectrow);
                    users.add(user);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testGetUsers() {
        List<User> users = userDAO.getUsers(50, 55);
        System.out.println(users);
    }



}
