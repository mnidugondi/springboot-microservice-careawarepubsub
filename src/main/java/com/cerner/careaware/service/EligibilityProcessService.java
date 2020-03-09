package com.cerner.careaware.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cerner.careaware.ibus.connection.exception.IBusConnectionException;
import com.cerner.ibus.cfc.eligibility.model.Acknowledgement;
import com.cerner.ibus.cfc.eligibility.model.request.EligibilityRequestMessage;
import com.cerner.ibus.cfc.eligibility.model.response.EligibilityResponseMessage;

@Service
public class EligibilityProcessService {
	private static Logger log = LoggerFactory.getLogger(EligibilityProcessService.class);

//	@Autowired
//	private EligibilityRequestService eligibilityRequestService;
//	
//	@Autowired
//	private EligibilityResponseService eligibilityResponseService;
//	
//	@Autowired
//	private RcvEligLogService rcvEligLogService;
//	
//	@Autowired
//	private EligibilityValidator validator;
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//	
//	@Autowired
//	private EligibilityLogger eligibilityLogger;
//	
//	@Autowired
//	private Publisher publisher;
//	
//	@Autowired
//	private UpdateService updateService;
//	
//	@Autowired
//	private ReadinessService readinessService;
//	
//	@Autowired
//	private CodedValuesService codedValueService;
	
	@Resource
	private Environment env;

	private String baseEnvironment;
	
	final class ResponseQuery {
		private final String endpoint;
		private final String host;
		
		public ResponseQuery(String endpoint, String host) {
			this.endpoint = endpoint;
			this.host = host;
		}
		
		public String getEndpoint() {
			return endpoint;
		}
		
		public String getHost() {
			return host;
		}
	}

	public void processEligibilityRequestMessage(EligibilityRequestMessage requestPayloadData, String correlationId)
			throws IBusConnectionException {
		

	}

	public void processEligibilityInquiryResponseMessage(Acknowledgement acknowledgement, String correlationId)
			throws IBusConnectionException {}
	
	public void processEligibilityResponseMessage(EligibilityResponseMessage responsePayload, String correlationId)
			throws IBusConnectionException {}
	
//	public EligibilityResponseMessage prepareEligibilityNotify(EligibilityResponseMessage response){
//	}
//	
//	public void updateResponseEntry(EligibilityResponse response, EligibilityResponseMessage payload){}
//	
//	public void saveEligibilityResponse(EligibilityResponseMessage payload,String svcProvTransId,EligibilityRequest request){}
//
//	public RcvEligLog saveRcvdAcknowledgement(Acknowledgement acknowledgement) {}
//
//	public void updateEligRqstWithSvcProvTransId(EligibilityRequest request, String svcProvTransId) {}
//
//	public RcvEligLog saveInitialReceivedPayload(Object pojo, String eventName) {}
//	
//	public RcvEligLog saveReceivedResponsePayload(EligibilityResponseMessage responseData) {}
//
//	private EligibilityRequest prepareEligibilityRequest(EligibilityRequestMessage requestData,
//			RcvEligLog rcvEligLog, String correlationId) {}
//
//	public Long generateTransactionId(EligibilityRequest eligibilityRequest) {}
//
//	private void saveEligibilityRequest(EligibilityRequest eligibilityRequest) {}
//
//	public EligibilityRequestMessage addServiceTraceToEligibilityInquiry(EligibilityRequestMessage requestData,
//			EligibilityRequest savedRequest) {}
//
//	private Trace createTrace(EligibilityRequest savedRequest) {}
//
//	public Acknowledgement prepareAcknowledgement(EligibilityRequestMessage requestPayloadData) {}
//
//	public Acknowledgement prepareNegativeAck(EligibilityRequestMessage requestPayloadData, String correlationId) {}
//
//	public RejectInformation createRejectInformation(String reasonCode, String reasonDesc, String reasonSuppDesc) {}
//	
//	public EligibilityViewResponseReply processEligibilityViewResponse(EligibilityViewResponseRequest viewResponseRequest) {}
//
//	private String getSvcProvEndPoint(String provider) {}
//	
//	private String getSvcProvHost(String host) {}
//
//	public ResponseQuery generateResponseEndPoint(String application, String transactionId,
//			String submitterId) {}
//
//	private boolean validateAppAgainstEnv() {}
//
//	private String generateEndPointWithTraceInfo(String application, String transactionId, String submitterId,
//			String svcProvEndPoint) {}
//
//	public HttpEntity<String> prepareRestTemplateHeader(List<CustomHttpHeader> customHeaders) {}
//
//	public void sendAcknowledgement(Acknowledgement ack, String type) throws IBusConnectionException {}
//
//	public void sendInquiry(EligibilityRequestMessage payload) throws IBusConnectionException {}
//	
//	public void sendEligibilityNotify(EligibilityResponseMessage payload) throws IBusConnectionException {}
//	
//	public void updateCfcPrcsInd(RcvEligLog rcvEligLog, Boolean valid, EligibilityRequest request) {}
//	
//	public EligibilityViewResponseReply createErrorViewResponseReply(String message, String details){}
//	
//	public EligibilityViewResponseReply createXfilesErrorViewResponseReply(RejectInformation rejection, ResponseInfo responseInfo) {}
//	
//	public String createNotFoundDetails(String svcProviderMne, String transactionId){}
//
	public void setBaseEnvironment(String baseEnvironment) {
		this.baseEnvironment = baseEnvironment;
		
	}
//	public String getBaseEnvironment() {
//		return baseEnvironment;
//	}
//	
//	public EligibilityUpdateReply processEligibilityUpdate(EligibilityUpdateMessage eligibilityUpdate) {}
//	
//	public EligibilityUpdateReply createUpdateReply(Boolean successIndicator, List<String> messages){
//		return new EligibilityUpdateReply.Builder()
//				.successful(successIndicator)
//				.messages(messages)
//				.build();
//	}
//	
//	public EligibilityReadinessCheck processEligibilityReadinessCheck(EligibilityReadinessCheck requestCheck){}
}

