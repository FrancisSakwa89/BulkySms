package com.sms.beans;


import com.sms.cdi.ApiProvider;
import com.sms.models.MessageStatus;
import com.sms.models.Sms;
import infobip.api.client.SendMultipleTextualSmsAdvanced;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.Destination;
import infobip.api.model.sms.mt.send.Message;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.SMSResponseDetails;
import infobip.api.model.sms.mt.send.textual.SMSAdvancedTextualRequest;
import org.jboss.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import static infobip.examples.Example.PASSWORD;
import static infobip.examples.Example.USERNAME;

@SuppressWarnings("CdiInjectionPointsInspection")
@Local
@Stateless
@ApiProvider(ApiProvider.Providers.INFOBIP)
public class InfoBipGateWay extends Bean<Sms> implements SmsI {
//    @EJB
//    SmsI smsI;

    @Inject
    private  Logger logger;

    @Override
    public boolean sendMessage(Sms sms) {
        SendMultipleTextualSmsAdvanced client = new SendMultipleTextualSmsAdvanced(new BasicAuthConfiguration(USERNAME, PASSWORD));

        Destination destination = new Destination();
        destination.setTo(sms.getRecepient());

        Sms message = new Sms();
        message.setSender(sms.getSender());
        message.setRecepient(String.valueOf(destination));
        message.setMessage(sms.getMessage());

        SMSAdvancedTextualRequest requestBody = new SMSAdvancedTextualRequest();
        requestBody.setMessages((List<Message>) message);

        SMSResponse response = client.execute(requestBody);

        for (SMSResponseDetails sentMessageInfo : response.getMessages()) {
            System.out.println("Message ID: " + sentMessageInfo.getMessageId());
            System.out.println("Receiver: " + sentMessageInfo.getTo());
            System.out.println("Message status: " + sentMessageInfo.getStatus().getName());
            System.out.println("------------------------------------------------");
        }

        sms.setMessageStatus(MessageStatus.RECIEVED);
        logger.info("Send by infobit"+ " "+ sms);
        return true;
    }
}
