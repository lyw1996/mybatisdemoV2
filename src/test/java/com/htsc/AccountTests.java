package com.htsc;


import com.htsc.dao.IAccountDao;
import com.htsc.domain.AccountUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * <h3>mybatisdemoV2</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-09-02 17:02
 **/
public class AccountTests {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();

        factory=builder.build(in);

        session=factory.openSession(true);

        accountDao=session.getMapper(IAccountDao.class);

    }


    @After
    public void tearDown() throws Exception {
        //提交
        // session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        List<AccountUser> accountUsers = accountDao.findAll();
        for (AccountUser au:accountUsers) {
            System.out.println(au);
        }
        assert accountUsers.size()==15;
    }
}
