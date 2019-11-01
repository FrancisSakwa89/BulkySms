package com.sms.ejb;

import com.sms.models.Sms;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public interface TextMessageQI {
    void addMessage(Sms sms);
    void checkValidity(Sms sms);
    boolean remove(Sms sms);

}
