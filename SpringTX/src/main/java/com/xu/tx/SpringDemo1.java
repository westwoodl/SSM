package com.xu.tx;

import com.xu.tx.service.AccountService;
import com.xu.tx.service.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx.xml")
public class SpringDemo1 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        accountService.transfer("冠西", "时刻", 1000d);
    }

    @Test
    public void test2(){
        accountService.transferAOP("冠西", "时刻", 1000d);
    }
}
