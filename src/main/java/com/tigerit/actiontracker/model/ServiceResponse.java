package com.tigerit.actiontracker.model;

import com.tigerit.actiontracker.model.response.ajax.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse <T> implements Serializable{
    private HttpStatus status; //OK_Failure

    private StatusCode statusCode; //code

    private T body;

    private List<T> errorList;
    
}
