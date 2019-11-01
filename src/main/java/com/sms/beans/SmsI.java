package com.sms.beans;

import com.sms.models.Sms;


public interface SmsI extends BeanI<Sms> {
//    List<Sms> allSentMessages();
//    List<Sms> allNotSentMessages();
   boolean sendMessage(Sms sms);

}
