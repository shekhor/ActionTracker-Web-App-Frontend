package com.tigerit.actiontracker.model.request.decisionlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionLogListRequest {
    private String projectId;

    private int pageNo;

    private int totalItemPerPage;
}
