package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
    //@Select("select count(*) from emp")
    //public Long count();

    /**
     * 分页查询,获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    //@Select("select * from emp limit #{start},#{pageSize}")
    //public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     * @return
     */
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender,LocalDate begin,LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);


/**
 * 插入员工信息到数据库
 *
 */
@Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values(#{username}, #{name}, #{gender}, #{image}, #{job},#{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);

@Select("select * from emp where id = #{id}")
    Emp getById(Integer id);



void update(Emp emp);



@Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

@Delete("delete from emp where dept_id=#{deptId}")
void deleteByDeptId(Integer deptId);
}
