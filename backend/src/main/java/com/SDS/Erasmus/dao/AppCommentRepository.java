package com.SDS.Erasmus.dao;

import com.SDS.Erasmus.domain.AppComment;
import com.SDS.Erasmus.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppCommentRepository extends JpaRepository<AppComment, UUID> {

}
