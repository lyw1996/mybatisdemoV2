package com.htsc;

import com.htsc.dao.IUserDao;
import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVoIds;
import com.htsc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

/**
 * <h3>mabatisdemo</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-09-02 11:49
 **/
public class UserDaoCrudTests {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void setUp() throws Exception {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();

        factory=builder.build(in);

        session=factory.openSession(true);

        userDao=session.getMapper(IUserDao.class);

    }

//    @Test
//    public void testFindAll() {
//        List<User> users = userDao.findAll();
//
//        for (User user:users) {
//            System.out.println(user);
//
//        }
//
//    }

    @Test
    public void testQueryByVo() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress("%南京%");
        List<User> users = userDao.findByVo(vo);
        assert users.size()==1;
    }

    @Test
    public void testFindOne() {
        User user=userDao.findById(41);
        System.out.println(user);
        assert user.getUserName().equals("张三");
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("华泰");
        user.setUserAddress("南京市建邺区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        //执行保存方法
        int id=userDao.saveUser(user);
        //验证保存结果
        User savedUser = userDao.findById(id);
        Assert.assertEquals(58,(int)user.getUserId());
        Assert.assertEquals(1,id);


    }

    @Test
    public void testUpdateUser() {
        int id=48;

        //根据id查询
        User user = userDao.findById(id);
        //更新
        user.setUserAddress("北京市顺义区");
        int res = userDao.updateUser(user);
        //验证
        User savedUser = userDao.findById(id);
        assert user.getUserAddress().equals("北京市顺义区");

    }

    @Test
    public void testDeleteUser() {
        int res=userDao.deleteUser(56);
        assert res==1;
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");

        assert users.size()==2;

        for (User user:users) {
            System.out.println(user);

        }

    }

    @Test
    public void testCount() {
        int res=userDao.count();
        assert res==12;
    }

    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress("%南京%");

        List<User> users = userDao.findByVo(vo);

        assert users.size() == 1;
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        assert users.size() == 6;

        for (User user:users
        ) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindInIds() {
        QueryVoIds voIds = new QueryVoIds();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(56);
        ids.add(57);
        ids.add(58);
        voIds.setIds(ids);
        List<User> users = userDao.findInIds(voIds);
        assert users.size()==2;

    }

    @After
    public void tearDown() throws Exception {
        //提交
       // session.commit();
        session.close();
        in.close();
    }
}
