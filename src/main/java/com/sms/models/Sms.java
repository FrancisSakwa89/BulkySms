package com.sms.models;

import javax.persistence.*;
import java.util.Date;

@Entity

@NamedQueries({
        @NamedQuery(name = "NQ_SELECT_SMS", query = "select s from Sms s"),
        @NamedQuery(name = "NQ_SELECT_NOT_SENT_SMS", query = "select s from Sms s"),
        @NamedQuery(name = "NQ_SELECT_SENT_SMS", query = "select s from Sms s "),


})
@Table(name = "tbl_sms")
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private String message;
    private String recepient;
    private MessageStatus messageStatus;
    private Date date;


    public Sms() {
    }

    public Sms(String message, String recepient, MessageStatus messageStatus, Date date) {
        this.message = message;
        this.recepient = recepient;
        this.messageStatus = messageStatus;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecepient() {
        return recepient;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "message='" + message + '\'' +
                ", recepient='" + recepient + '\'' +
                ", messageStatus=" + messageStatus +
                ", date=" + date +
                '}';
    }
}
