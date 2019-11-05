package com.sms.beans;

import com.sms.models.Sms;

import javax.ejb.Local;


@Local
public interface SmsI extends BeanI<Sms> {
//    List<Sms> allSentMessages();
//    List<Sms> allNotSentMessages();
   boolean sendMessage(Sms sms);


}
