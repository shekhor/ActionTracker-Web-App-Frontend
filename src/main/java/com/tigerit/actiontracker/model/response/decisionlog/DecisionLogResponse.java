package com.tigerit.actiontracker.model.response.decisionlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecisionLogResponse {
    private String id;

    private String decision;

    private String projectId;

    private String projectName;

    private String status;
}
