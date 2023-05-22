package org.sid.immatriculation.dto;
import lombok.*;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class OwnerRequest {
    private String name;
    private String email;
    private String birthDate;
}
