package com.devbuse.OrganizationManagement.data.repository;


import com.devbuse.OrganizationManagement.data.entity.ParticipantEntity;
import com.devbuse.OrganizationManagement.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipantRepository extends JpaRepository<ParticipantEntity, Long> {
}
