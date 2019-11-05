package com.sms.beans;

import com.sms.cdi.ApiProvider;
import com.sms.models.Sms;
import org.jboss.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Local
@Stateless
@ApiProvider(ApiProvider.Providers.AT)
public class AT extends Bean<Sms> implements SmsI{
    @Inject
    private transient Logger logger;

    @Override
    public boolean sendMessage(Sms sms) {
        String USERNAME = "sandbox";
        String API_KEY = "fa932c4ba6b844642262c5962ca1d2b81dfb28c43c49b3a26a198bb5128cbbdb";

        /* Initialize SDK */
//        AfricasTalking.initialize(USERNAME, API_KEY);
//
//        /* Get the SMS service */
//        SmsService smsService = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
//
//        /* That’s it, hit send and we’ll take care of the rest */
//        try {
//            List<Sms> response = smsService.send(sms);
//            for (Sms sms1 : response) {
//            }
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        }

        logger.info("Send by AT"+ " "+ sms);

        return true;
    }
}
