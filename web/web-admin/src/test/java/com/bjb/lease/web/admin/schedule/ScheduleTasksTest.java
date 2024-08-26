package com.bjb.lease.web.admin.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/6 上午11:44
 */
@SpringBootTest
class ScheduleTasksTest
{
    @Autowired
    private ScheduleTasks scheduleTasks;

    @Test
    public void test()
    {
        scheduleTasks.checkLeaseStatus();
    }

}