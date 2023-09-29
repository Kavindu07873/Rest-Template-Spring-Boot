package com.partyApi.rdPartyApi.controller;

import com.partyApi.rdPartyApi.dto.formdataDTO;
import com.partyApi.rdPartyApi.service.apiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class apiController {
    @Autowired
    private apiService postService;
    @PostMapping("/getPosts")
    public  Map<String,Object> getAllPosts(@ModelAttribute formdataDTO dto) {
        System.out.println();
        return   postService.getPosts(dto);
    }
}
