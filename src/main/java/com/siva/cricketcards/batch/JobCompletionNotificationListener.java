package com.siva.cricketcards.batch;

//
//import org.springframework.batch.core.BatchStatus;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.listener.JobExecutionListenerSupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import com.siva.cricketcards.dto.PlayerStats;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author: Siva Srinivasa Pasam
// *
// */
//@Component
//@Slf4j
public class JobCompletionNotificationListener {
//		extends JobExecutionListenerSupport {
//
//	private final JdbcTemplate jdbcTemplate;
//
//	@Autowired
//	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public void afterJob(JobExecution jobExecution) {
//		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
//			log.info("!!! JOB FINISHED! Time to verify the results");
//
//			jdbcTemplate.query("SELECT first_name, last_name FROM people",
//				(rs, row) -> new PlayerStats()
//			).forEach(playerStats -> log.info("Found <" + playerStats + "> in the database."));
//		}
	}
//
//}
