package com.atmecs.qa.utils;

import org.apache.log4j.Logger;

public class StatusCodeVerifier {
    public static final Logger logger =Logger.getLogger(StatusCode.class);
    public static void verifySuccessStatusCode(int statusCode) {
        try {
            assert statusCode == StatusCode.OK.getStatusCode();
            logger.info("PASS: STATUS_CODE :: " + statusCode);
        } catch (AssertionError error) {
            logger.error("FAIL: STATUS_CODE :: " + statusCode + " not 200" + error);
        } finally {
            if (statusCode == StatusCode.INTERNALSERVERERROR.getStatusCode()) {
                logger.error("The Server is down, please check the connections");
            }
        }
    }

    public static void verifyUserCreationStatusCode(int statusCode) {
        try {
            assert statusCode == StatusCode.CREATE.getStatusCode();
            logger.info("PASS: STATUS_CODE :: " + statusCode);
        } catch (AssertionError error) {
            logger.info("FAIL: STATUS_CODE :: " + statusCode + " neither 200 nor 201" + error);
        } finally {
            if (statusCode == StatusCode.INTERNALSERVERERROR.getStatusCode()) {
                logger.error("The Server is down, please check the connections");
            }

        }
    }

    public static void verifyDeleteUserStatusCode(int statusCode) {
        try {
            assert statusCode == StatusCode.NOCONTENT.getStatusCode();
            logger.info("PASS: STATUS_CODE :: " + statusCode);
        } catch (AssertionError error) {
            logger.info("FAIL: STATUS_CODE :: " + statusCode + " not 204 but" + error);
        } finally {
            if (statusCode == StatusCode.INTERNALSERVERERROR.getStatusCode()) {
                logger.error("The Server is down, please check the connections");
            }

        }

    }

    public static void verifyNotFoundStatusCode(int statusCode) {
        try {
            assert statusCode == StatusCode.NOTFOUND.getStatusCode();
            logger.info("PASS: STATUS_CODE :: " + statusCode);
        } catch (AssertionError error) {
            logger.info("FAIL: STATUS_CODE :: " + statusCode + " neither 200 nor 201" + error);
        } finally {
            if (statusCode == StatusCode.INTERNALSERVERERROR.getStatusCode()) {
                logger.error("The Server is down, please check the connections");
            }

        }
    }

    public static void verifyUserBadRequestStatusCode(int statusCode) {
        try {
            assert statusCode == StatusCode.BADREQUEST.getStatusCode();
            logger.info("PASS: STATUS_CODE :: " + statusCode);
        } catch (AssertionError error) {
            logger.info("FAIL: STATUS_CODE :: " + statusCode + " neither 200 nor 201" + error);
        } finally {
            if (statusCode == StatusCode.INTERNALSERVERERROR.getStatusCode()) {
                logger.error("The Server is down, please check the connections");
            }

        }
    }
    public static void verifyUnsupportedMediaType(int statusCode){
        try{
        assert statusCode == StatusCode.UNSUPPORTEDMEDIATYPE.getStatusCode();
        logger.info("PASS: STATUS_CODE :: " + statusCode);
            }catch (AssertionError error) {
            logger.info("FAIL: STATUS_CODE :: " + statusCode + "neither 200 nor 201" + error);
        } finally {
            if(statusCode == StatusCode.UNSUPPORTEDMEDIATYPE.getStatusCode()){
                logger.error("Unsupported Media Type");
            }
        }
    }
}
