package com.codehacks;

import com.codehacks.inbox.folders.Folder;
import com.codehacks.inbox.folders.FolderRepository;
import java.nio.file.Path;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InboxAPIApplication {
    
    @Autowired FolderRepository folderRepository;

    public static void main(String[] args) {
        SpringApplication.run(InboxAPIApplication.class, args);
    }

    /**
     * This is necessary to have the Spring Boot app use the Astr secure bundle 
     * to connect to the database.
     * @param astraProperties
     * @return 
     */
    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }
    
    @PostConstruct
    public void init() {
        folderRepository.save(new Folder("Rume7", "Inbox", "blue"));
        folderRepository.save(new Folder("Rume7", "Sent", "green"));
        folderRepository.save(new Folder("Rume7", "Important", "yellow"));
    }
}
