package com.codehacks.inbox.emails;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 *
 * @author Rhume
 */
@Table(value="unread_email_stats")
public class UnreadEmail {
    
    @PrimaryKeyColumn(name="user_id", ordinal=0, type=PrimaryKeyType.PARTITIONED)
    private String userId;
    
    @PrimaryKeyColumn(name="label", ordinal=1, type=PrimaryKeyType.CLUSTERED)
    private String label;
    
    @CassandraType(type= Name.INT)
    private int num_unread;

    public UnreadEmail() {}

    public UnreadEmail(String userId, String label, int num_unread) {
        this.userId = userId;
        this.label = label;
        this.num_unread = num_unread;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getNum_unread() {
        return num_unread;
    }

    public void setNum_unread(int num_unread) {
        this.num_unread = num_unread;
    }
}
