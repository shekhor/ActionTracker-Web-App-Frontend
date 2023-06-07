package com.tigerit.actiontracker.model.request.milestone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneCreateRequest {

    private String projectId;

    private String projectName;

    private String milestone;

    private String description;

    private Date milestoneDate;
}
