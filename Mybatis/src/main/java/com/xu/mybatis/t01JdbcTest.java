package com.xu.mybatis;

import org.junit.Test;

import java.sql.*;

public class t01JdbcTest {

    /**
     * 1.加载驱动
     * 2.创建连接
     * 3.设置sql
     * 4.创建statement
     * 5.设置参数
     * 6.执行查询，得到结果集
     * 7.遍历结果集
     * 8.关闭资源
     */
    @Test
    public void test(){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql:///mybatis?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "123456");

            String sql = "select * from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "王五");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("id") + ":" + resultSet.getString("username"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
