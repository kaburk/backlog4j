package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Revision;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class SharedFileJSONImpl implements SharedFile {

    private long id;
    private String type;
    private String name;
    private String dir;
    private long size;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User updatedUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDir() {
        return dir;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public User getCreatedUser() {
        return createdUser;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof SharedFile) {
            SharedFile other = (SharedFile)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("type", type)
                .append("name", name)
                .append("dir", dir)
                .append("size", size)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updatedUser", updatedUser)
                .append("updated", updated)
                .toString();
    }
}
