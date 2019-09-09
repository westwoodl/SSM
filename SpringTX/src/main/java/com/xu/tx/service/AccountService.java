package com.xu.tx.service;

public interface AccountService {
    void transfer(String from, String to, Double money);
    void transferAOP(String from, String to, Double money);
}
