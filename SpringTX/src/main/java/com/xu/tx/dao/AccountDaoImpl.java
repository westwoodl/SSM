package com.xu.tx.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void outMoney(String from, Double money) {
        jdbcTemplate.update("update account set money = money - ? where name = ?", money, from);
    }

    @Override
    public void inMoney(String to, Double money) {
        jdbcTemplate.update("update account set money = money + ? where name = ?", money, to);
    }
}
