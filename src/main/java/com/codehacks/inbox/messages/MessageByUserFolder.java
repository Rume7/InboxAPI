package com.codehacks.inbox.messages;

import java.util.Date;
import java.util.List;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 *
 * @author Rhume
 */
@Table(value="messages_by_user_folder")
public class MessageByUserFolder {
    
    @PrimaryKeyColumn(name="user_id", ordinal=0, type=PrimaryKeyType.PARTITIONED)
    private String user_id;
    
    @PrimaryKeyColumn(name="label", ordinal=1, type=PrimaryKeyType.PARTITIONED)
    private String label;
    
    @PrimaryKeyColumn(name="timestamp", ordinal=2, type=PrimaryKeyType.CLUSTERED)
    private Date timestamp;
    
    @CassandraType(type= Name.TEXT)
    private String message_id;
    
    @CassandraType(type= Name.LIST)
    private List<String> to;
    
    @CassandraType(type= Name.TEXT)
    private String subject;
    
    @CassandraType(type= Name.BOOLEAN)
    private boolean is_read; 

    public MessageByUserFolder() {
    }

    public MessageByUserFolder(String user_id, String label, Date timestamp, String message_id, List<String> to, String subject, boolean is_read) {
        this.user_id = user_id;
        this.label = label;
        this.timestamp = timestamp;
        this.message_id = message_id;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
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
