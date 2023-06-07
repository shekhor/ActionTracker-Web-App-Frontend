/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tigerit.actiontracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ServiceError implements Serializable {
    String code;
    String message;
    String description;

    public ServiceError() {
        code = "0";
        message = "";
    }

    public ServiceError(Metadata metaData) {
        this.code = metaData.code;
        this.message = metaData.message;
        this.description = metaData.description;
    }

    public ServiceError(String errorCode, String errorMessage) {
        this.code = errorCode;
        this.message = errorMessage;
    }

    @Override
    public String toString() {
        return "<TigerHRM-" + code + "> <" + message + ">";
    }
}

