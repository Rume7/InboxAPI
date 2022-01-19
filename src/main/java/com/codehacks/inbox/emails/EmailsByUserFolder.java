package com.codehacks.inbox.emails;

import java.util.List;
import java.util.UUID;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 *
 * @author Rhume
 */
@Table(value="emails_by_user_folder")
public class EmailsByUserFolder {
    
    @PrimaryKeyColumn(name="user_id", ordinal=0, type=PrimaryKeyType.PARTITIONED)
    private String user_id;
    
    @PrimaryKeyColumn(name="label", ordinal=1, type=PrimaryKeyType.PARTITIONED)
    private String label;
    
    @PrimaryKeyColumn(name="id", ordinal=2, type=PrimaryKeyType.CLUSTERED)
    private UUID id;
    
    @CassandraType(type= Name.LIST)
    private List<String> to;
    
    @CassandraType(type= Name.TEXT)
    private String subject;
    
    @CassandraType(type= Name.BOOLEAN)
    private boolean is_read; 

    public EmailsByUserFolder() {}

    public EmailsByUserFolder(String user_id, String label, UUID id, List<String> to, String subject, boolean is_read) {
        this.user_id = user_id;
        this.label = label;
        this.id = id;
        this.to = to;
        this.subject = subject;
        this.is_read = is_read;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }
}
