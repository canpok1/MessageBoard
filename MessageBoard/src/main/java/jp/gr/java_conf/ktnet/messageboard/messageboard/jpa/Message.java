/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ktnet.messageboard.messageboard.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vagrant
 */
@Entity
@Table(name = "message")
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id"),
    @NamedQuery(name = "Message.findByMessage", query = "SELECT m FROM Message m WHERE m.message = :message"),
    @NamedQuery(name = "Message.findByBeginDatetime", query = "SELECT m FROM Message m WHERE m.beginDatetime = :beginDatetime"),
    @NamedQuery(name = "Message.findByEndDatetime", query = "SELECT m FROM Message m WHERE m.endDatetime = :endDatetime")})
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "begin_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDatetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDatetime;
    @JoinColumn(name = "fk_account", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account fkAccount;

    public Message() {
    }

    public Message(Integer id) {
        this.id = id;
    }

    public Message(Integer id, String message, Date beginDatetime, Date endDatetime) {
        this.id = id;
        this.message = message;
        this.beginDatetime = beginDatetime;
        this.endDatetime = endDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getBeginDatetime() {
        return beginDatetime;
    }

    public void setBeginDatetime(Date beginDatetime) {
        this.beginDatetime = beginDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Account getFkAccount() {
        return fkAccount;
    }

    public void setFkAccount(Account fkAccount) {
        this.fkAccount = fkAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.gr.java_conf.ktnet.messageboard.messageboard.jpa.Message[ id=" + id + " ]";
    }
    
}
