package com.sms.jms;

import com.sms.beans.SmsI;
import com.sms.cdi.ApiProvider;
import com.sms.ejb.TextMessageQI;
import com.sms.models.MessageStatus;
import com.sms.models.Sms;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Local
@Stateless
public class FilterMessages {

    @Inject
    @ApiProvider(ApiProvider.Providers.AT)
    private SmsI smsI;
    @Inject
    @ApiProvider(ApiProvider.Providers.NEXMO)
    private SmsI sms2;

    @Inject
    @ApiProvider(ApiProvider.Providers.INFOBIP)
    private SmsI sms3;

    @EJB
    TextMessageQI textMessageQI;


    public void checkMessage(String option, Sms sms) {
        try{
            textMessageQI.addMessage(sms);
//        Sms sms = new Sms();
            textMessageQI.checkValidity(sms);
            sms.setMessageStatus(MessageStatus.PENDING);
            if (option.equalsIgnoreCase("AT")) {
                smsI.sendMessage(sms);
            } else if (option.equalsIgnoreCase("NEXMO")){
                sms2.sendMessage(sms);
            }
            else {
                sms3.sendMessage(sms);
            }
        }catch (Exception e){
            System.out.println("Error occurred..");
            e.printStackTrace();
        }


//
    }
}
