package com.tigerit.actiontracker.model.request.decisionlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionLogCreateRequest {

    private String id;

    private String decision;

    private String projectId;

    private String projectName;
}
