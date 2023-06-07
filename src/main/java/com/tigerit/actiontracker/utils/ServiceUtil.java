package com.tigerit.actiontracker.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigerit.actiontracker.component.logger.Loggable;
import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.exceptions.ActionTrackerResponseErrorHandler;
import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import static com.tigerit.actiontracker.utils.CookieConstants.ACCESS_TOKEN;
import static com.tigerit.actiontracker.utils.CookieConstants.REFRESH_TOKEN;

public class ServiceUtil {

    @Loggable
    private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);

    public static final String HOST = "http://192.168.5.242";
    public static final String PORT = ":80";
    public static final String API_CONTEXT = "/action-tracker-api";
    public static final String API_URL = HOST+PORT+API_CONTEXT;
    public static final String USER_LOGIN_API = API_URL + "/rest/auth/login";
    public static final String USER_SIGNUP_API = API_URL + "/rest/user/create";
    public static final String USER_CHECK_API = API_URL + "/rest/user/check-user-by-email";
    public static final String MILESTONE_LIST_API = API_URL + "/milestone/milestoneList";
    public static final String USER_VERIFY_API = API_URL + "/rest/user/activate";

    public static final String MILESTONE_CREATE_API = API_URL + "/milestone/create";
    public static final String DECISION_LOG_CREATE_API = API_URL + "/decision-log/create";
    public static final String DECISION_LOG_LIST_API = API_URL + "/decision-log/decisionLogList";
    private static HttpHeaders buildHttpHeader(HttpServletRequest request){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String accessToken;
        if (request != null) {
            Cookie accessCookie = WebUtils.getCookie(request, ACCESS_TOKEN);
            Cookie refreshCookie = WebUtils.getCookie(request, REFRESH_TOKEN);
            if (accessCookie != null) {
                accessToken = accessCookie.getValue();
                headers.setBearerAuth(accessToken);
            }
        }
        return headers;
    }
    private static HttpHeaders buildHttpHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public static <T, R> ServiceResponseExtended<T> sendRequest(HttpMethod method, HttpServletRequest request, String url, R requestObject,  Class<T> clazz) {
        HttpHeaders headers = buildHttpHeader(request);
        return sendHttpRequestServiceResponse(method, url, requestObject, clazz, headers);
    }

    public static <T, R> RestApiResponse<T> sendRequest(HttpMethod method, String url, R requestObject, Class<T> clazz) {
        HttpHeaders headers = buildHttpHeader();
        return sendHttpRequest(method, url, requestObject, clazz, headers);
    }

    public static <T, R> RestApiResponse<T> sendHttpRequest(HttpMethod method, String url, R requestObject, Class<T> clazz, HttpHeaders headers) {
        ParameterizedTypeReference<RestApiResponse<T>> typeRef
                = new ParameterizedTypeReference<RestApiResponse<T>>() {
            @Override
            public Type getType() {
                return new CustomParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{clazz});
            }
        };

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ActionTrackerResponseErrorHandler());
        HttpEntity<R> requestEntity = new HttpEntity<>(requestObject, headers);

        try {
            ResponseEntity<RestApiResponse<T>> response = restTemplate.exchange(url, method, requestEntity, typeRef, clazz);
            if (response.getStatusCode().equals(HttpStatus.OK)
                    || response.getStatusCode().equals(HttpStatus.CREATED)) {
                RestApiResponse<T> restApiResponse = response.getBody();
                if (restApiResponse != null && restApiResponse.getSuccess() != null) {
                    logger.debug("Response Body Not Null and Body has SuccessDetails");
                    return restApiResponse;
                } else if (restApiResponse != null && restApiResponse.getError() != null) {
                    logger.debug("Response Body Not Null and Body has ErrorDetails");
                    return restApiResponse;
                }
            } else if(response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                RestApiResponse<T> restApiResponse = response.getBody();
                 if (restApiResponse != null && restApiResponse.getError() != null) {
                    logger.debug("Response Body Not Null and Body has ErrorDetails");
                    return restApiResponse;
                } else {
                     logger.debug("Response Body Not Null and Body has no ErrorDetails");
                     return new RestApiResponse<>();
                 }
            } else{
                logger.debug("ResponseEntity Status : {}", response.getStatusCode().getReasonPhrase());
                return new RestApiResponse<>();
            }
            return new RestApiResponse<>();
        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            logger.debug("Exception While Parsing ResponseEntity", ex);
            String responseStatusBodyAsString = ex.getResponseBodyAsString();
            logger.debug("ResponseStatus Body : {}", responseStatusBodyAsString);
            return handleExceptionWithCare(ex, responseStatusBodyAsString);
        } catch (Exception ex) {
            logger.debug("Error While Rest Service Call ", ex);
            return new RestApiResponse<>();
        }
    }

    public static <T, R> ServiceResponseExtended<T> sendHttpRequestServiceResponse(HttpMethod method, String url, R requestObject, Class<T> clazz, HttpHeaders headers) {
        ParameterizedTypeReference<ServiceResponseExtended<T>> typeRef
                = new ParameterizedTypeReference<ServiceResponseExtended<T>>() {
            @Override
            public Type getType() {
                return new CustomParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{clazz});
            }
        };

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ActionTrackerResponseErrorHandler());

        HttpEntity<R> requestEntity = new HttpEntity<>(requestObject, headers);

        try {
            ResponseEntity<ServiceResponseExtended<T>> response = restTemplate.exchange(url, method, requestEntity, typeRef, clazz);
            if (response.getStatusCode().equals(HttpStatus.OK)
                    || response.getStatusCode().equals(HttpStatus.CREATED)) {
                ServiceResponseExtended<T> restApiResponse = response.getBody();
                if (restApiResponse != null && restApiResponse.getBody() != null) {
                    logger.debug("Response Body Not Null and Body has SuccessDetails");
                    return restApiResponse;
                } else if (restApiResponse != null && restApiResponse.getErrorList() != null) {
                    logger.debug("Response Body Not Null and Body has ErrorDetails");
                    return restApiResponse;
                }
            } else if(response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                ServiceResponseExtended<T> restApiResponse = response.getBody();
                if (restApiResponse != null && restApiResponse.getErrorList() != null) {
                    logger.debug("Response Body Not Null and Body has ErrorDetails");
                    return restApiResponse;
                } else {
                    logger.debug("Response Body Not Null and Body has no ErrorDetails");
                    return new ServiceResponseExtended<>();
                }
            } else{
                logger.debug("ResponseEntity Status : {}", response.getStatusCode().getReasonPhrase());
                return new ServiceResponseExtended<>();
            }
            return new ServiceResponseExtended<>();
        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            logger.debug("Exception While Parsing ResponseEntity", ex);
            String responseStatusBodyAsString = ex.getResponseBodyAsString();
            logger.debug("ResponseStatus Body : {}", responseStatusBodyAsString);
            return handleHttpExceptionWithCare(ex, responseStatusBodyAsString);
        } catch (Exception ex) {
            logger.debug("Error While Rest Service Call ", ex);
            return new ServiceResponseExtended<>();
        }
    }

    private static  <T> RestApiResponse<T> handleExceptionWithCare(HttpStatusCodeException ex,
                                                           String responseBodyAsString) {
        if (ex instanceof HttpClientErrorException) {
            logger.debug("Status - 4xx, HttpClientErrorException Occurred, Trying to Map using ObjectMapper");
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(responseBodyAsString, new TypeReference<RestApiResponse<T>>() {
                });
            } catch (IOException e) {
                logger.debug("IOException while mapping responseBody to RestApiResponse<T> ", ex);
                return new RestApiResponse<>();
            }

        } else if (ex instanceof HttpServerErrorException) {
            logger.debug("Status - 5xx, HttpServerErrorException Occurred, Trying to Map using ObjectMapper");
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(responseBodyAsString, new TypeReference<RestApiResponse<T>>() {
                });
            } catch (IOException e) {
                logger.debug("IOException while mapping responseBody to RestApiResponse<T> ", ex);
                return new RestApiResponse<>();
            }
        } else {
            return new RestApiResponse<>();
        }
    }

    private static  <T> ServiceResponseExtended<T> handleHttpExceptionWithCare(HttpStatusCodeException ex,
                                                                   String responseBodyAsString) {
        if (ex instanceof HttpClientErrorException) {
            logger.debug("Status - 4xx, HttpClientErrorException Occurred, Trying to Map using ObjectMapper");
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(responseBodyAsString, new TypeReference<ServiceResponseExtended<T>>() {
                });
            } catch (IOException e) {
                logger.debug("IOException while mapping responseBody to RestApiResponse<T> ", ex);
                return new ServiceResponseExtended<>();
            }

        } else if (ex instanceof HttpServerErrorException) {
            logger.debug("Status - 5xx, HttpServerErrorException Occurred, Trying to Map using ObjectMapper");
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(responseBodyAsString, new TypeReference<ServiceResponseExtended<T>>() {
                });
            } catch (IOException e) {
                logger.debug("IOException while mapping responseBody to RestApiResponse<T> ", ex);
                return new ServiceResponseExtended<>();
            }
        } else {
            return new ServiceResponseExtended<>();
        }
    }
}
