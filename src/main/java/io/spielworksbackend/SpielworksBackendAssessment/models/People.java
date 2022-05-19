package io.spielworksbackend.SpielworksBackendAssessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {
    private Long id;
    private String firstName;
    private String lastName;

}
