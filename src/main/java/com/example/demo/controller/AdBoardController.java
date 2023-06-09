package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.mvc.support.*;

import com.example.demo.domain.*;
import com.example.demo.service.*;

@Controller
@RequestMapping("adBoard")
public class AdBoardController {
	
	@Autowired
	private AdBoardService service;

	@GetMapping("list")
	public String list(Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "category", required = false) String category) {
		
		Map<String, Object> result = service.listBoard(page, search, type, category);
		
		model.addAllAttributes(result);
		
		return "adBoard/list";
	}
	
	@GetMapping("id/{id}")
	@PreAuthorize("isAuthenticated() and !hasAuthority('cheat')")
	public String board(@PathVariable("id") Integer id, Model model, Authentication authentication) {
		AdBoard board = service.getBoard(id, authentication); 
		
		model.addAttribute("board", board);
		
		return "adBoard/get";
	}
	
	@GetMapping("/modify/{id}")
	@PreAuthorize("isAuthenticated() and !hasAuthority('cheat')")
	public String modifyForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("board", service.getBoard(id));
		
		return "adBoard/modify";
	}
	
	@PostMapping("/modify/{id}")
	@PreAuthorize("isAuthenticated() and @customSecurityCheck.checkAdBoardWriter(authentication, #board.id)")
	public String modifyProcess(AdBoard board,
			@RequestParam(value = "files", required = false) MultipartFile[] addFiles,
			@RequestParam(value = "removeFiles", required = false) List<String> removeFileNames,
			RedirectAttributes rttr) throws Exception{
		boolean ok = service.modify(board, addFiles, removeFileNames);
		
		if(ok) {
			
			rttr.addFlashAttribute("message", board.getId() + "번 게시물이 수정되었습니다.");
			return "redirect:/adBoard/id/" + board.getId();
		} else {
			rttr.addFlashAttribute("message", board.getId() + "번 게시물이 수정되지 않았습니다.");
			return "redirect:/adBoard/modify/" + board.getId();
		}		
	}
	
	@PostMapping("remove")
	@PreAuthorize("isAuthenticated() and @customSecurityCheck.checkAdBoardWriter(authentication, #id)")
	public String remove(Integer id, RedirectAttributes rttr) {
		boolean ok = service.remove(id);
		
		if(ok) {
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되었습니다.");
			return "redirect:/adBoard/list";
		} else {
			return "redirect:/adBoard/id/" + id;
		}
	}
	
	@GetMapping("add")
	@PreAuthorize("isAuthenticated() and !hasAuthority('cheat')")
	public void addForm() {
		
	}
	
	@PostMapping("add")
	@PreAuthorize("isAuthenticated()")
	public String addProcess(AdBoard board,
			@RequestParam("files") MultipartFile[] files,
			RedirectAttributes rttr,
			Authentication authentication) throws Exception {
		board.setWriter(authentication.getName());
		boolean ok = service.addBoard(board, files);
		
		if(ok) {
			rttr.addFlashAttribute("message", board.getId() + "번 게시물이 등록되었습니다.");
			return "redirect:/adBoard/list";
		} else {
			rttr.addFlashAttribute("message", "게시물 등록 중 문제가 발생하였습니다.");
			rttr.addFlashAttribute("board", board);
			return "redirect:/adBoard/add";
		}
	}
	
	@PostMapping("/like")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> like(@RequestBody AdLike like, Authentication authentication) {
		
		if (authentication == null) {
			return ResponseEntity.status(403).body(Map.of("message", "로그인 해주세요"));
		} else {
			return ResponseEntity
					.ok()
					.body(service.like(like, authentication));
			
		}
		
	}
	
	
}














