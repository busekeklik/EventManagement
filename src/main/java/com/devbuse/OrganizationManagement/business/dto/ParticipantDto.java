package com.devbuse.OrganizationManagement.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto implements Serializable {

    private Long serialVersionUID = 1L;

    private Long eventID;

}
