package com.sms.beans;


import com.sms.cdi.ApiProvider;
import com.sms.models.MessageStatus;
import com.sms.models.Sms;

import javax.ejb.Local;

@Local
@ApiProvider(ApiProvider.Providers.INFOBIP)
public class InfoBipGateWay extends Bean<Sms> implements SmsI {
    @Override
    public boolean sendMessage(Sms sms) {
        //implementation of sending msg..
        sms.setMessageStatus(MessageStatus.RECIEVED);
        System.out.println("Send by infobit"+ " "+ sms);
        return true;
    }
}
