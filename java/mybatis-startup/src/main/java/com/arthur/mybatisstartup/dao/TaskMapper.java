package com.arthur.mybatisstartup.dao;

import com.arthur.mybatisstartup.entity.Task;
import com.arthur.mybatisstartup.entity.TaskExample;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TaskMapper {
    @SelectProvider(type=TaskSqlProvider.class, method="countByExample")
    long countByExample(TaskExample example);

    @DeleteProvider(type=TaskSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskExample example);

    @Delete({
        "delete from tasks",
        "where task_id = #{taskId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer taskId);

    @Insert({
        "insert into tasks (task_id, title, ",
        "start_date, due_date, status, ",
        "priority, description)",
        "values (#{taskId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{startDate,jdbcType=DATE}, #{dueDate,jdbcType=DATE}, #{status,jdbcType=TINYINT}, ",
        "#{priority,jdbcType=TINYINT}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(Task record);

    @InsertProvider(type=TaskSqlProvider.class, method="insertSelective")
    int insertSelective(Task record);

    @SelectProvider(type=TaskSqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="task_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="title", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="start_date", javaType=LocalDate.class, jdbcType=JdbcType.DATE),
        @Arg(column="due_date", javaType=String.class, jdbcType=JdbcType.DATE),
        @Arg(column="status", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="priority", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Task> selectByExampleWithBLOBs(TaskExample example);

    @SelectProvider(type=TaskSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="task_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="title", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="start_date", javaType=LocalDate.class, jdbcType=JdbcType.DATE),
        @Arg(column="due_date", javaType=String.class, jdbcType=JdbcType.DATE),
        @Arg(column="status", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="priority", javaType=Byte.class, jdbcType=JdbcType.TINYINT)
    })
    List<Task> selectByExample(TaskExample example);

    @Select({
        "select",
        "task_id, title, start_date, due_date, status, priority, description",
        "from tasks",
        "where task_id = #{taskId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="task_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="title", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="start_date", javaType=LocalDate.class, jdbcType=JdbcType.DATE),
        @Arg(column="due_date", javaType=String.class, jdbcType=JdbcType.DATE),
        @Arg(column="status", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="priority", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    Task selectByPrimaryKey(Integer taskId);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Task record, @Param("example") TaskExample example);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Task record);

    @Update({
        "update tasks",
        "set title = #{title,jdbcType=VARCHAR},",
          "start_date = #{startDate,jdbcType=DATE},",
          "due_date = #{dueDate,jdbcType=DATE},",
          "status = #{status,jdbcType=TINYINT},",
          "priority = #{priority,jdbcType=TINYINT},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where task_id = #{taskId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Task record);

    @Update({
        "update tasks",
        "set title = #{title,jdbcType=VARCHAR},",
          "start_date = #{startDate,jdbcType=DATE},",
          "due_date = #{dueDate,jdbcType=DATE},",
          "status = #{status,jdbcType=TINYINT},",
          "priority = #{priority,jdbcType=TINYINT}",
        "where task_id = #{taskId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Task record);
}