import edu.tongji.comm.typical.demo.domain.User;
import edu.tongji.comm.typical.demo.mappers.UserMapper;
import edu.tongji.comm.typical.demo.mappers.UserMapperWithAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by chen on 2017/6/29.
 */
public class MybatisTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void beforeClass() {
        // 构建sqlSessionFactory需要使用配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testAddUser() {

        String username = getRandomString(10);
        String password = getRandomString(10);
        String email = username + "@dianping.com";

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            userMapper.addUser(user);

            sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中

        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testGetUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserMapperWithAnnotation userMapperWithAnnotation = sqlSession.getMapper(UserMapperWithAnnotation.class);

        User user1 = userMapper.getUserById(1);
        User user2 = userMapperWithAnnotation.getUserById(2);

        System.out.println(user1);
        System.out.println(user2);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        user.setEmail(user.getUsername()+"@dianping,com");
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }




    /** 产生一个随机的字符串*/
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            builder.append(str.charAt(num));
        }
        return builder.toString();
    }

}
