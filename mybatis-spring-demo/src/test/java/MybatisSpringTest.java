import edu.tongji.comm.spring.demo.entity.User;
import edu.tongji.comm.spring.demo.dao.UserMapper;
import edu.tongji.comm.spring.demo.dao.UserMapperWithAnnotation;
import edu.tongji.comm.spring.demo.services.UserService;
import edu.tongji.comm.typical.demo.utils.RandomUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
    private UserMapper userMapper;

    @Autowired
    private UserMapperWithAnnotation userMapperWithAnnotation;

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {

        // 直接利用sqlSessionFactory
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);

        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testGetUserById2() {

        // 直接利用userMapper
        User user2 = userMapper.getUserById(2);
        User user3 = userMapperWithAnnotation.getUserById(3);
        System.out.println(user2);
        System.out.println(user3);

    }


    @Test
    public void testAddUser() {
        String username = RandomUtil.getRandomString(10);
        String password = RandomUtil.getRandomString(10);
        String email = username + "@dianping.com";

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

//        userMapper.addUser(user);

        userService.addUser(user);

        // 打印刚插入的记录的Id
        System.out.println(user.getId());
    }

    @Test
    public void testGetUsers() {
        List<User> users = userMapper.getUsers(50, 55);
        System.out.println(users);
    }



}
