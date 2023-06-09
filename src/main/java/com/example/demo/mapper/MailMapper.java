package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface MailMapper {

	@Insert("""
			INSERT INTO AuthenticNum (authenticNUM)
			VALUES (#{randomNumber})
			""")
	Integer saveRandomNum(int randomNumber);

	@Select("""
			SELECT authenticNUM
			FROM AuthenticNum
			""")
	Integer getAuthenticatedNum();

	@Delete("""
			DELETE FROM AuthenticNum
			""")
	void deleteAuthenticatedNum();

	
}
