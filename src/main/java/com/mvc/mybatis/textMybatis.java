package com.mvc.mybatis;

import com.mvc.bean.one;
import com.mvc.dao.oneMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class textMybatis {


    public static void main(String[] args) throws IOException {

        String resource = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<one> jdbc = sqlSession.selectList("sql.selectOne", "jdbc");
//        System.out.println(jdbc.toString());


        /**
         * 接口编程方式查询 创建一个接口方法 sql文件命名空间为接口全路径  sql语句id为接口方法名
         * */
        oneMapper mapper = sqlSession.getMapper(oneMapper.class);
        oneMapper mapper2 = sqlSession.getMapper(oneMapper.class);

        one jdbc = mapper.getSelect("孙悟空","男");
        one jdbc2 = mapper2.getSelect("孙悟空","男");
        System.out.println(jdbc);
        System.out.println(jdbc2);


    }




}
