package com.htsc;

import com.htsc.dao.IRoleDao;
import com.htsc.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * <h3>mybatisdemoV2</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-09-03 09:51
 **/
public class RoleTests {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public void setUp() throws Exception {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();

        factory=builder.build(in);

        session=factory.openSession(true);

        roleDao=session.getMapper(IRoleDao.class);

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
        List<Role> roles = roleDao.findAll();
        Assert.assertEquals(3,roles.size());

        for (Role role:roles){
            System.out.println("每个角色的信息：");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
