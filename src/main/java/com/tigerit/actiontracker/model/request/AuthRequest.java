package com.tigerit.actiontracker.model.request;

import com.tigerit.actiontracker.model.request.signup.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest implements Serializable {

    private String username;

    private String password;

    private UserType userType;

}
