package com.devbuse.OrganizationManagement.business.dto;

import com.devbuse.OrganizationManagement.data.entity.ParticipantEntity;
import com.devbuse.OrganizationManagement.data.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String eventDescription;
    private String eventLocation;
    private Date startDate;
    private Date endDate;
    private List<UserEntity> userEntities;
    private List<ParticipantEntity> participantEntities;

}
