package com.ankit.cricketstats.data;


import javax.sql.DataSource;

import com.ankit.cricketstats.model.Ball;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing

public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private final String[] FIELDS_NAME= new String[]{"match_id","season","start_date","venue","innings","ball","batting_team","bowling_team","striker","non_striker","bowler","runs_off_bat","extras","wides","noballs","byes","legbyes","penalty","wicket_type","player_dismissed","other_wicket_type","other_player_dismissed" };

    @Bean
    public FlatFileItemReader<BallInput> reader() {
    return new FlatFileItemReaderBuilder<BallInput>()
        .name("ballItemReader")
        .resource(new ClassPathResource("ball-data.csv"))
        .delimited()
        .names(FIELDS_NAME)
        .fieldSetMapper(new BeanWrapperFieldSetMapper<BallInput>() {{
        setTargetType(BallInput.class);
        }})
        .build();
    }

    @Bean
    public BallDataProcessor processor() {
    return new BallDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Ball> writer(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Ball>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO people (matchId,season,startDate,venue,innings,over,ball,battingTeam,bowlingTeam,striker,nonStriker,bowler,runsOffBat,extras,wides,noballs,byes,legbyes,penalty,wicketType,playerDismissed,otherWicketType,otherPlayerDismissed)"+
        "VALUES (:matchId,:season,:startDate,:venue,:innings,:over,:ball,:battingTeam,:bowlingTeam,:striker,:nonStriker,:bowler,:runsOffBat,:extras,:wides,:noballs,:byes,:legbyes,:penalty,:wicketType,:playerDismissed,:otherWicketType,:otherPlayerDismissed)"
        )
        .dataSource(dataSource)
        .build();
    }

}