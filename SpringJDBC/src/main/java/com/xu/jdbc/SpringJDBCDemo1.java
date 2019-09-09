package com.xu.jdbc;

import com.xu.jdbc.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbc模板的使用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application01Jdbc.xml")
public class SpringJDBCDemo1 {


    @Test
    public void test(){
        //创建连接池（spring内置的连接池）
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_jdbc?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //jdbc模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account value (null, ?, ?)", "冠西", 10000d);
    }

    @Resource private JdbcTemplate jdbcTemplate;
    /**
     * 将dataSource和jdbc模板交给springioc
     */
    @Test
    public void test2(){
        jdbcTemplate.update("insert into account value (null, ?, ?)", "时刻", 5550d);
    }

    /**
     * dbcp连接池
     */
    @Test
    public void test_c3p0(){
        jdbcTemplate.update("insert into account value (null,?,?)", "c3p0prewdasd", 5555d);
    }
//jdbc模板的操作数据库，增删改查
    @Test
    public void test4(){
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", "杨世琳", 2000d, 6);
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where id = ?", 7);

    }

    //查询 queryForObject
    @Test
    public void testSelect(){
        System.out.println(
                jdbcTemplate.queryForObject("select name from account where id = ?", String.class, 6));

        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);

        Account account =
                jdbcTemplate.queryForObject("select * from account where id = ?",
                        new MyRowMapper(), 6);
        System.out.println(account);
    }

    //查询多个
    @Test
    public void testQueryList(){
        List<Account> list = jdbcTemplate.query("select * from account", new MyRowMapper());
        System.out.println(list);
    }

    class MyRowMapper implements RowMapper<Account>{

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account1 = new Account();
            account1.setId(resultSet.getInt("id"));
            account1.setName(resultSet.getString("name"));
            account1.setMoney(resultSet.getDouble("money"));
            return account1;
        }
    }
}
