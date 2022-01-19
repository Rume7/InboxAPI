package com.codehacks.inbox.messages;

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
@Table(value="message_by_id")
public class Message {
    
    @PrimaryKeyColumn(name="user_id", ordinal=0, type=PrimaryKeyType.PARTITIONED)
    private UUID id;

    @CassandraType(type= Name.TEXT)
    private String from;
    
    @CassandraType(type= Name.LIST)
    private List<String> tos;
    
    @CassandraType(type= Name.TEXT)
    private String subject;
    
    @CassandraType(type= Name.TEXT)
    private String body;
    
    public Message() {}
    
    public Message(UUID id, String from, List<String> to, String subject, String body) {
        this.id = id;
        this.from = from;
        this.subject = subject;
        this.body = body;
        to.forEach(action -> {tos.add(action);});
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return tos;
    }

    public void setTo(List<String> to) {
        to.forEach(action -> {tos.add(action);});
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
