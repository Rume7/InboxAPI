package com.codehacks.inbox.folders;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rhume
 */
@Service
public class FolderService {
    
    public List<Folder> fetchDefaultFolders(String userId) {
        return Arrays.asList(
            new Folder(userId, "Inbox", "blue"),
            new Folder(userId, "Sent Items", "green"),
            new Folder(userId, "Important", "red")
        );
    }
    
}
