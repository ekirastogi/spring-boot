package com.ekiras.domain.embeddable;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author ekansh
 * @since 22/7/16
 */
@Embeddable
public class Dates {

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @org.springframework.data.annotation.Version
    private int version;

    public Dates(){}
    public Dates(Date dateCreated,Date lastUpdated,int version){
        this.dateCreated=dateCreated;
        this.lastUpdated=lastUpdated;
        this.version=version;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
