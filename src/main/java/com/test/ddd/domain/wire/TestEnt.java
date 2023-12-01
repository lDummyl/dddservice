package com.test.ddd.domain.wire;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.UUID;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.ALL)
@Configurable(autowire = Autowire.BY_TYPE)
public class TestEnt {

    @Autowired
    @Transient
    private TestService testService;

    @Id
    private UUID id;

    private int incr;

    public TestEnt(UUID id, int incr) {
        this.id = id;
        this.incr = incr;
    }

    public void call() {
        testService.call();
    }
}
