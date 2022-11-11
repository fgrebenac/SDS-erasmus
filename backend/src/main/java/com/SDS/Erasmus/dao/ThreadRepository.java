package com.SDS.Erasmus.dao;


import com.SDS.Erasmus.domain.Thread;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ThreadRepository extends JpaRepository<Thread, UUID> {

}
