package com.devbuse.OrganizationManagement.data.repository;

import com.devbuse.OrganizationManagement.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
