package com.xu.tx.dao;

public interface AccountDao {
    void outMoney(String from, Double money);
    void inMoney(String to, Double money);
}
