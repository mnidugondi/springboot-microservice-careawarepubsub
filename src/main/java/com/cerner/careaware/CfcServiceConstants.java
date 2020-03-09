package com.cerner.careaware;

public class CfcServiceConstants {

	public static final String ACKNOWLEDGEMENT = "Acknowledgement";
	public static final String ELIGIBILITY_REQUEST = "Eligibility Request";
	public static final String ELIGIBILITY_INQUIRY = "Eligibility Inquiry";
	public static final String ELIGIBILITY_RESPONSE = "Eligibility Response";
	public static final String ELIGIBILITY_NOTIFY = "Eligibility Notify";
	public static final String ELIGIBILITY_UPDATE = "Eligibility Update";
	public static final String FIRST_ACK = "FirstACK";
	public static final String SECOND_ACK = "SecondACK";
	public static final String NEGATIVE_ACK = "NegativeACK";

	public static final String CFC_APP_NAME = "cern_cfcl";
	public static final String HDX_APP_NAME = "HDXTS";
	public static final String XFILES_APP_NAME = "XFILES";
	public static final String ENV_CLOUD_LOCAL = "CLOUD_LOCAL";
	public static final String ENV_CLOUD_DEV = "CLOUD_DEV";
	public static final String ENV_REVCLOUD_DEV = "REVCLDDEV";
	public static final String FILLENNIUM_APP_NAME = "Fillennium";
	public static final String DXH_APP_NAME = "DXH";
	public static final String HDX_ENDPOINT = "cfc.svcprov.endpoint.hdxts";
	public static final String DXH_ENDPOINT = "cfc.svcprov.endpoint.dxh";
	public static final String HDX_HOST = "cfc.svcprov.host.hdxts";
	public static final String DXH_HOST = "cfc.svcprov.host.dxh";
	public static final String HDX_READY_ENDPOINT = "cfc.svcprov.readinessEndpoint.hdxts";

	public static final int ORIGINATING_APP_TRACE = 0;
	public static final int FIRST = 0;

	public static final String MISSING_APP_TRANS_ID_RJCT_DESC = "missing application transaction id";
	public static final String MISSING_APP_NAME_RJCT_DESC = "missing/invalid application name";

	public static final int REJECT_REASON_TYPE_CD = 33;
	public static final int HDX_ELIG_CVG_STS_CD = 40;
	public static final int GENDER_CD = 14;
	public static final int INDV_REL_CD = 22;
	public static final int INS_TYPE_CD = 25;
	public static final int ORIG_APPL_NAME_CD = 41;
	public static final int SVC_TYPE_CD = 34;
	public static final int ELIG_OR_BNFT_INFO_CD = 15;
	public static final int YES_NO_COND_OR_RESP_CD = 1;
	public static final int COV_LVL_CD = 3;
	public static final int QTY_QLFY_CD = 31;
	public static final int TIME_PER_QLFY_CD = 35;
	public static final int DATE_TIME_QLFY_CD = 11;
	public static final int CD_TYPE_MODIFY_PERMISSION_NAME = 42;
	public static final int CD_TYPE_MODIFY_PERMISSION_VALUE = 43;
	public static final String MODIFY_PERMISSION_NAME_TYPE_BENEFITS = "Benefits";
	public static final String MODIFY_PERMISSION_NAME_TYPE_DISCREPANCIES = "Discrepancies";
	public static final String MODIFY_PERMISSION_VALUE_TYPE_HIDDEN = "Hidden";
	public static final String MODIFY_PERMISSION_VALUE_TYPE_ENABLE = "Enable";
	public static final String MODIFY_PERMISSION_VALUE_TYPE_DISABLE = "Disable";

	public static final String APP_DATA_MISSING_MNE = "15";

	public static final String CD_TYPE = "Cd Type";
	public static final String TYPE_CD = "Type Cd";
	public static final String MNE = "Mne";
	public static final String CD_VALUE = "Cd Value";
	public static final String SELF = "Self";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String UNKNOWN_CODE = "U";
	public static final String NOT_APPLICABLE = "W";
	public static final String DEFAULT_SVC_TYPE_CODE = "30";
	public static final String INDIVIDUAL = "Individual";
	public static final String PAYER = "Payer";

	//Update Database Constants
	public static final String ACCEPT = "accept";
	public static final String REJECT = "reject";
	public static final String BYPASS = "bypass";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String NAME_SUFFIX = "nameSuffix";
	public static final String DATE_OF_BIRTH = "birthDate";
	public static final String GENDER_CODE = "genderCode";
	public static final String MEMBER_IDENTIFIER = "memberIdentifier";
	public static final String HEALTH_PLAN_GROUP_NUMBER = "healthPlanGroupNumber";
	public static final String HEALTH_PLAN_GROUP_NAME = "healthPlanGroupName";
	public static final String HEALTH_PLAN_NAME = "healthPlanName";

	// Rule Abbreviations

	public static final String BAD_PLAN_ALERT = "BadPlanAlert";
	public static final String HISTORICAL_ALERT = "HistoricalAlert";

	// Rule Data Constants

	public static final String CORRECT_HEALTH_PLAN = "correctHealthPlanIdentifierValue";
	public static final String CORRECT_HEALTH_PLAN_NAME = "correctHealthPlanName";
	public static final String ORIGINAL_RESPONSE_DATE = "originalResponseDate";
	public static final String EXPIRATION_DATE = "expirationDate";

	// Render UI Constants

	public static final String SUCCESS = "Success";
	public static final String ALERT = "Alert";
	public static final String ERROR = "Error";
	public static final String PATIENT_NAME = "Patient Name";
	public static final String MEMBER_ID = "Member ID";
	public static final String GROUP_NUMBER = "Group Number";
	public static final String GROUP_NAME = "Group Name";
	public static final String BIRTH_DATE = "Birth Date";
	public static final String GENDER = "Gender";
	public static final String SEE_MESSAGES = "see Messages";
	public static final String HEALTH_PLAN = "Health Plan";
	public static final String UNKNOWN = "Unknown";
	public static final String IN_NETWORK = "In Network";
	public static final String OUT_OF_NETWORK = "Out of Network";

	public static final String NULL_VALUE = "Null";
	public static final String INVALID_VALUE = "Invalid Value";
	public static final int VALID_DATE_LENGTH = 8;
	public static final int YEAR_INDEX = 4;
	public static final int MONTH_INDEX = 2;
	public static final String DATE_TARGET_FORMAT = "MM/dd/yyyy";
	public static final String YEAR_BASE_PATTERN_ONE = "yyyy/MM/dd";
	public static final String MONTH_BASE_PATTERN_ONE = "MM/dd/yyyy";
	public static final String YEAR_BASE_PATTERN_TWO = "yyyy-MM-dd";
	public static final String MONTH_BASE_PATTERN_TWO = "MM-dd-yyyy";

	public static final String CONTENT_TYPE = "Content-Type";
	public static final String PUBLISH_ELIGIBILITY_REQUEST_ACKNOWLEDGEMENT_CONTENT_TYPE =
			"application/x.cerner.eligibility-request-acknowledgement.v1+json";
	public static final String PUBLISH_ELIGIBILITY_INQUIRY_RESPONSE_ACKNOWLEDGEMENT_CONTENT_TYPE =
			"application/x.cerner.eligibility-inquiry-response-acknowledgement.v1+json";
	public static final String PUBLISH_ELIGIBILITY_INQUIRY_CONTENT_TYPE =
			"application/x.cerner.eligibility-inquiry.v1+json";
	public static final String PUBLISH_ELIGIBILITY_NOTIFY_CONTENT_TYPE =
			"application/x.cerner.eligibility-notify.v1+json";

	// Render UI Error Messages

	public static final String MISSING_VALID_TRANSACTION_ID_ERROR_MSG =
			"Eligibility response cannot be found.\nContact your system administrator to resolve the issue.";

	public static final String MISSING_VALID_TRANSACTION_TYPE_CODE_DETAILS =
			"Invalid value: Transaction ID type";

	public static final String RESPONSE_NOT_FOUND_ERROR_DETAILS =
			"Invalid value: Transaction ID ";

	public static final String INVALID_RESPONSE_FROM_SVC_PROVIDER_ERROR_MSG =
			"Eligibility response cannot be displayed due to a system issue. Contact your system administrator to resolve the issue.";

	public static final String INVALID_RESPONSE_FROM_SVC_PROVIDER_ERROR_DETAILS =
			"Invalid JSON format";

	public static final String UNABLE_TO_REACH_SVC_PROVIDER_ERROR_MSG =
			"Eligibility response cannot be displayed due to a system issue. Try again later or"
			+ " contact your system administrator to resolve the issue if the problem persists.";

	public static final String UNABLE_TO_REACH_SVC_PROVIDER_ERROR_DETAILS =
			"The eligibility service cannot contact the eligibility service provider.";

	// Update Error Messages

	public static final String NO_TRANSACTION_ID_ERROR =
			"Invalid Eligibility Update Message: no transaction identifiers.";

	public static final String NO_VALID_ID_ERROR =
			"Invalid Eligibility Update Message: no valid transaction identifiers.";

	public static final String NO_CORRESPONDING_REQUEST_ERROR =
			"Invalid Eligibility Update Message: no corresponding eligibility request.";

	public static final String NO_CORRESPONDING_RESPONSE_ERROR =
			"Invalid Eligibility Update Message: no corresponding eligibility response.";

	public static final String BENEFIT_DUPLICATE_ROW_EXISTS_ERROR =
			"Unable to save Applied Benefit Duplicate Row Already Exists.";

	public static final String NON_MATCHING_USER_ACTION_ERROR =
			"Unable to save Name Discrepancies: Non-Matching User Actions found.";

	public static final String INVALID_GENDER_CODE_ERROR =
			"Unable to save Gender Discrepancy, invalid Gender Code.";

	public static final String HEALTH_PLAN_NAME_NOT_FOUND_ERROR =
			"Unable to save Health Plan ID Discrepancy, Health Plan Name not found on Update Message.";

	public static final String INVALID_APPLIED_BENEFIT_ERROR =
			"Unable to save Applied Benefit, Benefit is invalid.";

	// HTTP Response Code

	public static final int NOT_FOUND = 404;

	// Timeouts

	public static final int CONNECTION_TIMEOUT = 10000;
	public static final int READ_TIMEOUT = 10000;

	// DB constants

	public static final String DB_NAME = "cfceligibility";
	public static final String USER = "user";
	public static final String SECRET = "password";

	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String HIBERNATE_DIALECT = "hibernate.dialect";
	public static final String HIBERNATE_DIALECT_VALUE = "org.hibernate.dialect.MySQL5Dialect";
	public static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	public static final String HIBERNATE_HBM2DDL_VALUE = "none";

	// Logger Constants
	public static final String DEBUG_LEVEL = "DEBUG";
	public static final String ERROR_LEVEL = "ERROR";
	public static final String INFO_LEVEL = "INFO";

	// Liquibase Constants
	public static final String LIQUIBASE_ELIGIBILITY_MAIN_CHANGELOG_PATH = "classpath:db/changelog/eligibilityservice_changelog_main.xml";
	public static final String QUERY_CREATE_SCHEMA_IF_NOT_EXIST = "CREATE SCHEMA IF NOT EXISTS ";
	public static final String LIQUIBASE_MESSAGE_PREFIX = "------ Liquibase Maintainence ------ ";
	public static final String LIQUIBASE_MESSAGE_STARTING = "Starting --- main change log path = ";
	public static final String LIQUIBASE_MESSAGE_COMPLETE = "Completed ";
	public static final String LIQUIBASE_MESSAGE_FAILED = "FAILED";
	public static final String LIQUIBASE_MESSAGE_UPDATE_STARTING = "Liquibase Update Invoked";
	public static final String LIQUIBASE_MESSAGE_REQUEST_CONNECTION = "Requesting  Connection";
	public static final String LIQUIBASE_MESSAGE_ACQUIRED_CONNECTION = "Connection Acquired= ";
	public static final String LIQUIBASE_MESSAGE_CREATE_SCHEMA_IF_NOT_EXISTS = "Create Schema if not exists Started. ";
	public static final String LIQUIBASE_MESSAGE_CREATE_SCHEMA_IF_NOT_EXISTS_COMPLETE = "Create Schema if not exists Complete. ";
	public static final String LIQUIBASE_MESSAGE_CREATE_SCHEMA_IF_NOT_EXISTS_FAILED = "Create Schema if not exists FAILED!!!. ";
	public static final String LIQUIBASE_MESSAGE_GETDATABASECHANGELOG_START = "Getting Changelog file. Start ";
	public static final String LIQUIBASE_MESSAGE_GETDATABASECHANGELOG_DONE = "Getting Changelog file. Done ";
	public static final String LIQUIBASE_MESSAGE_FAILED_CLOSING_SQLEXCEPTION = "Failed closing connection with SQLException";
	public static final String LIQUIBASE_MESSAGE_FAILED_CLOSING_UNCHECKED = "Failed closing connection with unchecked exception";

	// Static map for coded value constant
	public static final String RESOURCE_LOCATION_PROD = "db/changelog/data/cd_values.csv";
	public static final String RESOURCE_LOCATION_CLOUD_DEV = "db/changelog/data/cd_values_cloud_dev.csv";
	public static final String CODEDVALUE_STATIC_MAP_LOADING_ERROR = "***** Error during loading static maps of Coded values for tenant : ";
	public static final int LOADING_ERROR = -1;
	public static final int NOT_STARTED = 0;
	public static final int START_LOADING = 1;
	public static final int IN_PROGRESS = 2;
	public static final int COMPLETED = 3;
	public static final String SEPARATOR = "-";
	// Readiness Check Constants
	public static final String CFC_ELIG_SERVICE = "CFC_ELIG_SERVICE";
	public static final String CFC_ELIG_DATABASE = "CFC_ELIG_DATABASE";
	public static final String VERSION = "version";
	}
