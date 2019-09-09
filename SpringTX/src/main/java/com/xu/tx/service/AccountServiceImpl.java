package com.xu.tx.service;

import com.xu.tx.dao.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * 转账
 */
/**使用注解事务*/
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)//隔离级别和传播行为
public class AccountServiceImpl implements AccountService {
//    @Resource
    private AccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override//转账，必须添加事务
    /**
     * 编程式的事务管理，写起来麻烦，破坏代码
     */
    public void transfer(String from, String to, Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(from, money);
                int exeception = 1/0;
                accountDao.inMoney(to, money);
            }
        });
    }

    /**
     * 使用AOP完成事务管理（面向切面编程的思想）
     *     有两种方式：1.xml 2.注解
     */
    public void transferAOP(String from, String to, Double money){
        accountDao.outMoney(from, money);
        int e = 1/0;
        accountDao.inMoney(to, money);
    }
}
