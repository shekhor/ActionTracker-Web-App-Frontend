package com.tigerit.actiontracker.model.request.signup;

import com.tigerit.actiontracker.model.request.signup.Status;
import com.tigerit.actiontracker.model.request.signup.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String encryptedPassword;

    private String confirmEncryptedPassword;

    private String userId;

    private BigInteger userRoleId;

    private BigInteger organizationId;

    private String domainName;

    private Status status;

    private UserType userType;
}
