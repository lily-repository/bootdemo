package com.renli.bootdemo;

import com.renli.bootdemo.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class BootdemoApplicationTests {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testInsertOrder() {
        for (int i = 0; i < 10; i++) {
            orderDao.insertOrder(new BigDecimal((i + 1) * 5), 1L, "WAIT_PAY");
        }
    }

    @Test
    public void testSelectOrderbyIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(458411212305072129L);
        ids.add(458411212334432256L);
        List<Map> maps = orderDao.selectOrderbyIds(ids);
        System.out.println(maps);
    }
}
