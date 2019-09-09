package com.xu.tx;

import com.xu.tx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx_anno.xml")
public class SpringDemo2AnnoTX {

    /**
     * 注解事务，开启注解配置，使用@Transactional
     */
    @Resource
    private AccountService accountService;

    @Test
    public void test(){
        accountService.transferAOP("冠西", "时刻", 1000d);
    }
}
