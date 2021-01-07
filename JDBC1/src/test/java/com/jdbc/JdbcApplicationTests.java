package com.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class JdbcApplicationTests {

    @Autowired//spring boot会自动帮我们注入数据库连接池，如果没有指定，默认就是tomcat的数据库连接池
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println(druidDataSource.getInitialSize());
        System.out.println(dataSource.getClass());
        System.out.println(connection.getClass());
        System.out.println(connection);
        connection.close();
    }

}
