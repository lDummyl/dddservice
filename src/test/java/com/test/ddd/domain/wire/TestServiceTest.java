package com.test.ddd.domain.wire;

import com.test.ddd.repo.TestRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TestServiceTest {

    @Autowired
    TestRepo testRepo;

    @Test
    public void test(){
        testRepo.findAll().get(0).call();
    }

}