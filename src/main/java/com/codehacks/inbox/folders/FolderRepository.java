package com.codehacks.inbox.folders;

import java.util.List;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rhume
 */
@Repository
public interface FolderRepository extends CassandraRepository<Folder, String>{
    
    List<Folder> findAllById(String id);
    
}
