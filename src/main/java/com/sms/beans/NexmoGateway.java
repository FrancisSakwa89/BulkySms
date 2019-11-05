package com.sms.beans;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import com.sms.cdi.ApiProvider;
import com.sms.models.MessageStatus;
import com.sms.models.Sms;
import org.jboss.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import java.io.IOException;

@SuppressWarnings("CdiInjectionPointsInspection")
@Local
@Stateless
@ApiProvider(ApiProvider.Providers.NEXMO)
public class NexmoGateway extends Bean<Sms> implements SmsI {
    private NexmoClient client;

    public void init(ServletConfig config) {
        // Load configuration from the servlet container:
        String api_key = config.getInitParameter("api_key");
        String api_secret = config.getInitParameter("api_secret");

        client = new NexmoClient(new TokenAuthMethod(api_key, api_secret));
    }
//    @EJB
//    SmsI smsI;
    @Inject
    private transient Logger logger;

    @Override
    public boolean sendMessage(Sms sms) {
        try {
            String API_KEY ="fa932c4ba6b844642262c5962ca1d2b81dfb28c43c49b3a26a198bb5128cbbdb";
            String API_SECRET ="fa932c4ba6b844642262c5962ca1d2b81dfb28c43c49b3a26a198b";
            AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
            NexmoClient client = new NexmoClient(auth);

            TextMessage message = new TextMessage(sms.getSender(), sms.getRecepient(),sms.getMessage());

            //There may be more than one response if the SMS sent is more than 160 characters.
            SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(message);
            for (SmsSubmissionResult response : responses) {
                logger.info(response);
                sms.setMessageStatus(MessageStatus.RECIEVED);
            }

//                smsI.add(sms);



        } catch (IOException e) {
            logger.error("Error sending message via Nexmo gateway");
            e.printStackTrace();
        } catch (NexmoClientException e) {
            logger.error("Error sending message via Nexmo gateway");
            e.printStackTrace();
        }

        logger.info("Send by nexmo"+ " "+ sms);
        return true;
    }
}
