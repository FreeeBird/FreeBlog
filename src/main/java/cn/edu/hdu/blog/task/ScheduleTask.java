package cn.edu.hdu.blog.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    @Scheduled(cron = "5 0 0 * * ?")
    public void task1(){
        System.out.println("task1");
    }


}
