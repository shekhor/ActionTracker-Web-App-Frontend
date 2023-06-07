package com.tigerit.actiontracker.model.request.milestone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneListRequest {

    private String projectId;

    private int pageNo;

    private int totalItemPerPage;
}
