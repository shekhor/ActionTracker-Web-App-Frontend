package com.tigerit.actiontracker.model.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckUserExistServiceRequest implements Serializable {

    private String email;

}
