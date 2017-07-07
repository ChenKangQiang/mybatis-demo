import edu.tongji.comm.spring.demo.domain.User;
import edu.tongji.comm.spring.demo.mappers.UserMapper;
import edu.tongji.comm.spring.demo.mappers.UserMapperWithAnnotation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);

        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetUserById2() {

        User user = userMapper.getUserById(1);
        User user2 = userMapperWithAnnotation.getUserById(2);
        System.out.println(user);
        System.out.println(user2);

    }


}
