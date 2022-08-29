package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        //根据主键id查询数据
        //Emp emp = mapper.selectByPrimaryKey(1);
        //System.out.println(emp);

        //查询所有数据
        //List<Emp> list = mapper.selectByExample(null);
        //list.forEach(System.out::println);

        //根据指定的条件查询数据
        //EmpExample empExample = new EmpExample();
        //empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        //empExample.or().andGenderEqualTo("男");
        //List<Emp> list = mapper.selectByExample(empExample);
        //list.forEach(System.out::println);

        //测试普通修改方法
        Emp emp = new Emp(1, "小黑", null, "女");
        //测试普通修改功能
        mapper.updateByPrimaryKey(emp);
        //测试选择性修改功能 如果当前字段为Null不会进行修改
        mapper.updateByPrimaryKeySelective(emp);
    }

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页
        Page<Object> page = PageHelper.startPage(5, 4);
        List<Emp> list = mapper.selectByExample(null);
        //在查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
