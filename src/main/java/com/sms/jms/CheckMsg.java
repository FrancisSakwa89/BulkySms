package com.sms.jms;

import com.sms.beans.SmsI;
import com.sms.cdi.ApiProvider;
import com.sms.models.MessageStatus;
import com.sms.models.Sms;

import javax.ejb.Local;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
public class CheckMsg {
    @Inject
    @ApiProvider(ApiProvider.Providers.AT)
    private SmsI  smsI;

    @Inject
    @ApiProvider(ApiProvider.Providers.NEXMO)
    private SmsI  sms2;
//    @Schedule(minute = "*", hour = "*", second = "*/30")
    public void resend() {
        Sms sms = new Sms();
        if (sms.getMessageStatus().equals(MessageStatus.PENDING)) {


        }
    }

}