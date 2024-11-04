package com.devbuse.OrganizationManagement.business.dto;

import com.devbuse.OrganizationManagement.data.entity.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;
    private String email;
    private List<EventEntity> eventEntityList;

}
