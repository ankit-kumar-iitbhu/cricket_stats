package com.ankit.cricketstats.data;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      System.out.println("!!! JOB FINISHED! Time to verify the results");

      jdbcTemplate.query("SELECT striker , bowler , startDate FROM ball",
        (rs, row) -> "batsman" + rs.getString(1) + "bowler" +rs.getString(2) + "date" + rs.getString(3)
      ).forEach( str -> System.out.println(str));
    }
  }
}