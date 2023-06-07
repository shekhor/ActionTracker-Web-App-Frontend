package com.tigerit.actiontracker.model.response.user;

import com.tigerit.actiontracker.model.response.ajax.ErrorDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckUserExistServiceResponse extends ErrorDetails {

    private boolean data = false;
}
