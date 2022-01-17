package com.codehacks.inbox.controllers;

import com.codehacks.inbox.folders.Folder;
import com.codehacks.inbox.folders.FolderRepository;
import com.codehacks.inbox.folders.FolderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Rhume
 */
@Controller
public class InboxController {
    
    @Autowired FolderRepository folderRepository;
    
    @Autowired FolderService folderService;
         
    @GetMapping(value="/")
    public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        
        if (principal == null || !StringUtils.hasText(principal.getAttribute("login"))) {
            return "index";
        }
        
        String userId = principal.getAttribute("login");
        List<Folder> userFolders = folderRepository.findAllById(userId);
        model.addAttribute("userFolders", userFolders);
        
        List<Folder> defaultFolders = folderService.fetchDefaultFolders(userId);
        model.addAttribute("defaultFolders", defaultFolders);        
        
        return "inbox-page";
    }
}
