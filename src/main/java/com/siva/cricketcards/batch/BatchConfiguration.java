package com.siva.cricketcards.batch;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.siva.cricketcards.dto.PlayerStats;
//import com.siva.cricketcards.service.StatisticsService;
//
///**
// * @author: Siva Srinivasa Pasam
// *
// */
////@Configuration
////@EnableBatchProcessing
public class BatchConfiguration {
//
//	@Autowired
//    public StatisticsService statisticsService;
//
//	@Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
////    @Bean
////    public ItemReader<? extends PlayerStats> reader() {
////    	return new ItemReaderBuilder<PlayerStats>()
////                .name("personItemReader")
////                .resource(statisticsService.getPlayerStats(1934))
//////                .names()
////                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayerStats>() {{
////                    setTargetType(PlayerStats.class);
////                }})
////                .build();
////    }
//
//    @Bean
//    public JdbcBatchItemWriter<PlayerStats> writer(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<PlayerStats>()
//            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//            //TODO
//            .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
//            .dataSource(dataSource)
//            .build();
//    }
//
//    @Bean
//    public Job getPlayerStatsJob(JobCompletionNotificationListener listener, Step step1) {
//        return jobBuilderFactory.get("getPlayerStatsJob")
//            .incrementer(new RunIdIncrementer())
//            .listener(listener)
//            .flow(step1)
//            .end()
//            .build();
//    }
//
////    @Bean
////    public Step step1(JdbcBatchItemWriter<PlayerStats> writer) {
////        return stepBuilderFactory.get("step1")
////            .<PlayerStats, PlayerStats> chunk(10)
////            .reader(reader())
////            .writer(writer)
////            .build();
    }
//}
