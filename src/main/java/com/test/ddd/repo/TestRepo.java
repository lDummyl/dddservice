package com.test.ddd.repo;

import com.test.ddd.domain.wire.TestEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestRepo extends JpaRepository<TestEnt, UUID> {


}
