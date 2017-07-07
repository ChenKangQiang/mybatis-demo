import edu.tongji.comm.spring.demo.domain.User;
import edu.tongji.comm.spring.demo.mappers.UserMapper;
import edu.tongji.comm.spring.demo.mappers.UserMapperWithAnnotation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen on 2017/6/29.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-another.xml"})
public class MybatisSpringTest2 {


    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("classpath:spring-context-another.xml");

//    UserMapper userMapper = (UserMapper) context.getBean("userMapper");

//    在junit 中，貌似无法自动注入 由 org.mybatis.spring.mapper.MapperScannerConfigurer 扫描 生成的bean
//    @Autowired
//    private UserMapper userMapper;

    @Test
    public void testGetUserById() {

        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.getUserById(1);

        System.out.println(user);

    }


}
