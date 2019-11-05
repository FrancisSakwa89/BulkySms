package com.sms.ejb;

import com.sms.models.MessageStatus;
import com.sms.models.Sms;


import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

@Local
@Stateless
public class TextMessageQueue implements TextMessageQI {
    private Queue<Sms> smsLinkedList = new LinkedList<>();
@EJB
TextMessageQI textMessageQI;

    @Override
    public void addMessage(Sms sms) {
        smsLinkedList.add(sms);

    }

    @Override
    public void checkValidity(Sms sms) {
        Date date = new Date();
        Date dateSend = sms.getDate();
        int diff = (int) (date.getTime() - dateSend.getTime());
        int sendPeriod = (int) TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
        if(sendPeriod>24){
            sms.setMessageStatus(MessageStatus.EXPIRED);
            smsLinkedList.remove(sms);
        }
        else {
            textMessageQI.addMessage(sms);
            smsLinkedList.poll();

        }
    }

    @Override
    public boolean remove(Sms sms) {
        for (Sms sms1: smsLinkedList){
            smsLinkedList.remove(sms1);
            return true;
        }
        return false;
    }
}
