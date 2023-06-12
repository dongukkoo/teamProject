package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdCommentService {
	
	@Autowired
	private AdCommentMapper mapper;

	public List<AdComment> list(Integer boardId) {
		
		return mapper.selectAllByBoardId(boardId);
	}

	public Map<String, Object> add(AdComment comment) {
		comment.setMemberId("user5");
		
		var res = new HashMap<String, Object>();
		
		int cnt = mapper.insert(comment);
		if(cnt == 1) {
			res.put("message", "댓글이 등록되었습니다.");
		} else {
			res.put("message", "댓글이 등록되지 않았습니다.");
		}
		
		return res;
	}

	public void remove(Integer id) {
		mapper.deleteById(id);
		
	}

	public AdComment get(Integer id) {
		return mapper.selectById(id);
	}

	public void update(AdComment comment) {
		mapper.update(comment);
	}

}