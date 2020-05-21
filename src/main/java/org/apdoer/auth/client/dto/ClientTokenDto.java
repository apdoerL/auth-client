package org.apdoer.auth.client.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date 2020/5/18 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientTokenDto implements Serializable {

    private static final long serialVersionUID = 5583774190562788618L;
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private Integer expiresIn;
    private String scope;
}
