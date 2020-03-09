package com.cerner.careaware;

import static com.cerner.careaware.CfcServiceConstants.HDX_APP_NAME;
import static com.cerner.careaware.CfcServiceConstants.INFO_LEVEL;
import static com.cerner.ibus.cfc.eligibility.client.impl.CfcEligibilityClientImpl.PUBLISH_ELIGIBILITY_INQUIRY_ACKNOWLEDGEMENT;
import static com.cerner.ibus.cfc.eligibility.client.impl.CfcEligibilityClientImpl.PUBLISH_ELIGIBILITY_REQUEST;
import static com.cerner.ibus.cfc.eligibility.client.impl.CfcEligibilityClientImpl.PUBLISH_ELIGIBILITY_RESPONSE;

import java.io.IOException;
import java.util.Properties;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;

import com.cerner.careaware.context.config.AppConfig;
import com.cerner.careaware.context.config.parent.ParentContextProvider;
import com.cerner.careaware.ibus.connection.ConnectionConfig;
import com.cerner.careaware.ibus.connection.exception.IBusConnectionException;
import com.cerner.careaware.ibus.connection.exception.IBusHandlerException;
import com.cerner.careaware.ibus.connection.message.IBusMessage;
import com.cerner.careaware.ibus.connection.message.MessageHandler;
import com.cerner.careaware.ibus.connection.message.MessageSubscription;
import com.cerner.careaware.ibus.connection.message.MessageSubscriptionManager;
import com.cerner.careaware.ibus.connection.request.HandleClient;
import com.cerner.careaware.ibus.core.annotation.DataGroup;
import com.cerner.careaware.ibus.core.annotation.DataName;
import com.cerner.careaware.ibus.service.IBusService;
import com.cerner.careaware.ibus.service.annotation.Start;

import com.cerner.ibus.cfc.eligibility.client.CfcEligibilityClient;
import com.cerner.ibus.cfc.eligibility.model.Acknowledgement;
import com.cerner.ibus.cfc.eligibility.model.request.EligibilityRequestMessage;
import com.cerner.ibus.cfc.eligibility.model.response.EligibilityResponseMessage;
import com.cerner.careaware.service.EligibilityProcessService;
import com.cerner.icommand.ContextData;
import com.cerner.management.measurement.queue.Publisher;

@HandleClient(CfcEligibilityClient.class)
@DataGroup.Bind("SpringbootMicroserviceCareawarepubsubApplication")
public class SpringbootMicroserviceCareawarepubsubApplication extends IBusService{
	
	private MessageSubscriptionManager inquirySubMgr;
	private MessageSubscriptionManager acksSubMgr;
	private MessageSubscriptionManager responseSubMgr;
	
	private AnnotationConfigApplicationContext configAppContext;
	private ConnectionConfig config;
	
	
	private Publisher publisher;
	private EligibilityProcessService eligibilityProcessService;
	
	private static Logger log = LoggerFactory.getLogger(SpringbootMicroserviceCareawarepubsubApplication.class);	
	

	public SpringbootMicroserviceCareawarepubsubApplication(@DataName.Bind("inquires") MessageSubscriptionManager inquirySubMgr, 
			@DataName.Bind("acks") MessageSubscriptionManager  acksSubMgr,
			@DataName.Bind("responses") MessageSubscriptionManager responseSubMgr,
			Publisher publisher,
			ConnectionConfig config) {
		
		this.inquirySubMgr = inquirySubMgr;
		this.acksSubMgr = acksSubMgr;
		this.responseSubMgr = responseSubMgr;
		this.publisher = publisher;
		this.config = config;
		
		inquirySubMgr.sharedDurable("SpringbootMicroserviceCareawarepubsubApplication");
		acksSubMgr.sharedDurable("SpringbootMicroserviceCareawarepubsubApplication");
		responseSubMgr.sharedDurable("SpringbootMicroserviceCareawarepubsubApplication");
		
	}
	
	@Start
	public void startService(final ContextData ctxData) throws IBusConnectionException, IOException {
		//AllowableValuesService.loadCdValues(config.getBaseEnvironment());
		initializeSpringContainer(ctxData);
		subscribe();
		log.info("Service started successfully.");
	}
	
	
	private void initializeSpringContainer(final ContextData ctxData) {
		
		if(configAppContext == null) {
			configAppContext = new AnnotationConfigApplicationContext();
		}
		configAppContext.getBeanFactory().registerSingleton("publisher",publisher);
		configAppContext.register(AppConfig.class);
		
		log.info("Context registered using AppConfig.class.");
		
		ApplicationContext parentAppContext = ParentContextProvider.getApplicationContext();
		
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		if (parentAppContext != null) {
			Environment environment = parentAppContext.getEnvironment();
			configAppContext.setEnvironment((ConfigurableEnvironment) environment);
			log.info("**** Setup ConfigurableEnvironment from parent SpringBoot ApplicationContext into new spring container ****");
		} else {
			Properties sysProperties1 = System.getProperties();
			PropertiesPropertySource propSource = new PropertiesPropertySource("ServiceContextData", sysProperties1);
			configAppContext.getEnvironment().getPropertySources().addFirst(propSource);
			log.error("Failed to get parent springBoot application context");
			log.error("Setting up parent system properties into new spring container");
		}

		configAppContext.refresh();
		
		eligibilityProcessService = configAppContext.getBean(EligibilityProcessService.class);
		eligibilityProcessService.setBaseEnvironment(config.getBaseEnvironment());
	}
	
	private void subscribe() throws IBusConnectionException {
		subscribeToEligibilityRequest();
		subscribeToEligibilityInquiryAcknowledgement();
		subscribeToEligibilityResponse();
		log.info("Subscribed successfully");
	}
	
	private void subscribeToEligibilityInquiryAcknowledgement() throws IBusConnectionException {
		final MessageSubscription.Builder builder = new MessageSubscription.Builder(new MessageHandler() {

			@Override
			public void onMessage(IBusMessage msg) throws IBusHandlerException, Exception {
				Acknowledgement message = (Acknowledgement)msg.deserializePayload();
				String cernerCorrelationId = msg.getCorrelationId();
				log.error("Setting up parent system properties into new spring container1");
				eligibilityProcessService.processEligibilityInquiryResponseMessage(message,cernerCorrelationId);
			}
			
		});
		builder.channels(PUBLISH_ELIGIBILITY_INQUIRY_ACKNOWLEDGEMENT);
		acksSubMgr.register(builder.build());
		log.info("Subscribed to channel {}", PUBLISH_ELIGIBILITY_INQUIRY_ACKNOWLEDGEMENT);
	}

	private void subscribeToEligibilityRequest() throws IBusConnectionException {
		final MessageSubscription.Builder builder = new MessageSubscription.Builder(new MessageHandler() {

			@Override
			public void onMessage(IBusMessage msg) throws IBusHandlerException, Exception {
				EligibilityRequestMessage message = ((EligibilityRequestMessage)msg.deserializePayload());
				String cernerCorrelationId = msg.getCorrelationId();
				log.error("Setting up parent system properties into new spring container2");
				
				eligibilityProcessService.processEligibilityRequestMessage(message, cernerCorrelationId);
			}
			
		});
		builder.channels(PUBLISH_ELIGIBILITY_REQUEST);
		inquirySubMgr.register(builder.build());
		log.info("Subscribed to channel " + PUBLISH_ELIGIBILITY_REQUEST);		
	}
	
	private void subscribeToEligibilityResponse() throws IBusConnectionException {
		final MessageSubscription.Builder builder = new MessageSubscription.Builder(new MessageHandler() {

			@Override
			public void onMessage(IBusMessage msg) throws IBusHandlerException, Exception {
				EligibilityResponseMessage message = ((EligibilityResponseMessage)msg.deserializePayload());
				String cernerCorrelationId = msg.getCorrelationId();
				log.error("Setting up parent system properties into new spring container3");
				
				eligibilityProcessService.processEligibilityResponseMessage(message, cernerCorrelationId);
			}
			
		});
		builder.channels(PUBLISH_ELIGIBILITY_RESPONSE);
		responseSubMgr.register(builder.build());
		log.info("Subscribed to channel " + PUBLISH_ELIGIBILITY_RESPONSE);
	}


}
