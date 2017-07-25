import edu.tongji.comm.spring.demo.dao.JoyFootMonthEventDAO;
import edu.tongji.comm.spring.demo.entity.JoyFootMonthEventEntity;
import edu.tongji.comm.spring.demo.request.JoyFootMonthReqDTO;
import edu.tongji.comm.spring.demo.response.JoyFootMonthRespDTO;
import edu.tongji.comm.spring.demo.services.JoyEventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen on 2017/7/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class JoyEvenServiceTest {

    @Autowired
    private JoyEventService joyEventServiceImpl;

    @Autowired
    private JoyFootMonthEventDAO joyFootMonthEventDAO;

    @Test
    public void testQueryJoyFootMonthByUserID() {

        System.out.println(joyFootMonthEventDAO);
        System.out.println(joyEventServiceImpl);

        JoyFootMonthReqDTO reqDTO = new JoyFootMonthReqDTO();

        // 数据库中已经存在，查询券信息
        reqDTO.setUserID(new Long(1));
        reqDTO.setPlatForm(1);

        JoyFootMonthRespDTO respDTO = joyEventServiceImpl.queryJoyFootMonthByUserID(reqDTO);

        System.out.println(respDTO);
    }


    @Test
    public void testAddJoyFootMonthByUserIDD() {

        JoyFootMonthReqDTO reqDTO = new JoyFootMonthReqDTO();
        reqDTO.setUserID(new Long(99));
        reqDTO.setPlatForm(1);

        JoyFootMonthRespDTO respDTO = joyEventServiceImpl.queryJoyFootMonthByUserID(reqDTO);

        System.out.println(respDTO);
    }




}
