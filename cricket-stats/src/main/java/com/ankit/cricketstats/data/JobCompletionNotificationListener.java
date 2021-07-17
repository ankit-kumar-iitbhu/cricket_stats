package com.ankit.cricketstats.data;

import java.sql.ResultSet;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private final JdbcTemplate jdbcTemplate;

  String response_to_string(ResultSet rs){
    String resp_str="";
    for(int i=1;i<=26;i++){
      try{
        resp_str+= ", ";
        resp_str+= rs.getString(i);
      }
      catch(Exception e){
        break;
      }
    }
    return resp_str;
  }


  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      System.out.println("!!! JOB FINISHED! Time to verify the results");

      // jdbcTemplate.query("SELECT match_id,innings,over,ball FROM ball",
      //   (rs, row) -> "ball id " + rs.getString(1) +" "+rs.getString(2)+" " + rs.getString(3)+ "-" +rs.getString(4)
      // ).forEach( str -> System.out.println(str));

      jdbcTemplate.query("SELECT count(*) FROM ball",
        (rs, row) -> "total row imported " + rs.getString(1)
      ).forEach( str -> System.out.println(str));


      jdbcTemplate.query("SELECT * FROM ball limit 10",
        (rs, row) -> response_to_string(rs)
      ).forEach( str -> System.out.println(str));
      
    }
  }
}