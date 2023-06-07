/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tigerit.actiontracker.utils;

/**
 *
 * @author Ataur
 */

import com.tigerit.actiontracker.model.ServiceError;


import java.util.Hashtable;

public class ErrorCodes {
    // system error
    public static final String ERROR_SYSTEM_UNSPECIFIED = "Unspecified";


    //custom
    public static final int ERROR_CUSTOM_MESSAGE = 701;


    /* BVRSError objects initialization */
    private static Hashtable<Integer, ServiceError> errorCodes;
    static {
        errorCodes = new Hashtable<Integer, ServiceError>();
        errorCodes.put(new Integer(ERROR_SYSTEM_UNSPECIFIED),
                       new ServiceError(ERROR_SYSTEM_UNSPECIFIED,
                                        "Unspecified error. Please contact with system administrator."));
    }

    /**
     * Returns ServiceError object for the error code
     * @param errorCode Error number
     * @return ServiceError object for the error number.
     * If number not found then returns ERROR_SYSTEM_UNSPECIFIED
     */
    public static ServiceError getServiceError(int errorCode) {
        if (errorCodes.containsKey(new Integer(errorCode))) {
            return errorCodes.get(new Integer(errorCode));
        } else {
            return errorCodes.get(new Integer(ERROR_SYSTEM_UNSPECIFIED));
        }
    }

    /**
     * Returns ServiceError object for the error code. The error message is
     * formatted using the arguments.
     * @param errorCode Error number
     * @param args  Arguments referenced by the format specifiers in the format
     * string. If there are more arguments than format specifiers, the extra
     * arguments are ignored. The number of arguments is variable and may be zero.
     * @return ServiceError object having formatted message
     */
    public static ServiceError getServiceError(int errorCode, Object... args) {
        ServiceError error = getServiceError(errorCode);
        ServiceError customError = new ServiceError();
        customError.setCode(error.getCode());
        if(errorCode == ERROR_CUSTOM_MESSAGE){
            try{
                customError.setMessage(String.valueOf(args[0]));
                return customError;
            }catch(Exception ex){

            }
        }
        customError.setMessage(error.getMessage().format(error.getMessage(),args));
        return customError;
    }
    

}
