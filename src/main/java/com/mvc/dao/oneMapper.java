package com.mvc.dao;

import com.mvc.bean.one;
import org.apache.ibatis.annotations.Param;

public interface oneMapper {
    //如果多个参数 需要用 @Param 然后指定名称
    //如果需要的参数和bean中实体类变量名称一致 可以直接传pojo 实体类
    //如果多个参数不是和bean中的数据 可以用传入  map
    //如果多个参数不是和bean中的数据 但是经常使用   编写一个DTO 数据传输对象
    /*##特别注意:如果是Collection (List、Set)类型或者是数组，
      也会特殊处理。也是把传入的list或者数组封装在map中。
      key: Collection ( collection)， 如果是List还可以使用这个key(list)
      数组(array)
      public Employee getEmpById(List<Integer> ids);
      取值:取出第一个id的值: #{list[0]}  */

    /*
  * #{} :是以预编译的形式，将参数设置到sq1语句中; PreparedStatement;防止sq1注入
    ${} :取出的值直接拼装在sq1语句中;会有安全问题;
    大多情况下，我们去参数的值都应该去使用#{ };
    原生jdbc不支持占位符的地方我们就可以使用$ { }进行取值
    比如分表,排序;按照年份分表拆分
    select * from ${year}_ salary where xxx;
    select * from tb1_ employee order by ${f_ name} ${order}
    */

    //当使用oracle 数据库时 mybatis中的null值 是OTHER oralce不认识 需要设置#{name,jdbctype=null}
    public one getSelect(@Param("name") String name,@Param("sex") String sex);
}

