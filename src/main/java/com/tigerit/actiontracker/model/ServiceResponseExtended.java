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
public class ServiceResponseExtended<T> extends ServiceResponse<T> implements Serializable {
    private long pageNo;

    private long pageSize;

    private long totalHits;
}

