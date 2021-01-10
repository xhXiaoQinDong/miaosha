package com.xqd.miaosha.dao;

import com.xqd.miaosha.domain.MiaoshaUser;
import com.xqd.miaosha.domain.User;
import org.apache.ibatis.annotations.*;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
@Mapper
public interface MiaoshaUserDao {
	
	@Select("select * from miaosha_user where id = #{id}")
	public MiaoshaUser getById(@Param("id")long id);

	@Update("update miaosha_user set password = #{password} where id = #{id}")
	public void update(MiaoshaUser toBeUpdate);

	@Insert("insert into miaosha_user (id,username,password,salt,register_date)values (#{id},#{username},#{password},#{salt},#{registerDate}) ")
	@Options(useGeneratedKeys=true,keyProperty="id", keyColumn="id")
	boolean insertMiaoShaUser(User user);

	@Select("select * from miaosha_user where username=#{userName}")
	User selectByUserName(@Param("userName")String userName);
}
