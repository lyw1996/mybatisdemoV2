package com.htsc.test;

import com.htsc.dao.IUserDao;
import com.htsc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <h3>mabatisdemo</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-09-02 10:32
 **/
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();

        SqlSessionFactory factory=builder.build(in);

        SqlSession session=factory.openSession();

        IUserDao userDao=session.getMapper(IUserDao.class);

        List<User> users=userDao.findAll();
        for (User user:users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
