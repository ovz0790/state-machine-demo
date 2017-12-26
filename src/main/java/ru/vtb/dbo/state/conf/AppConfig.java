package ru.vtb.dbo.state.conf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.statemachine.StateMachine;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Olga_Zlobina
 */
@Configuration
public class AppConfig {

    @Bean
    public Map<Long, StateMachine<States, Events>> machine(){
        final ConcurrentMap<Long, StateMachine<States, Events>> machines = new ConcurrentHashMap<>();
        return machines;
    }
/*
    public static void main(String[] args){
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"A", "B","SAVE_DRAFT"});
        list.add(new String[]{"B", "C","GET_SIGNATURE"});
        list.add(new String[]{"B", "D", "HAS_ERROR"});
        list.add(new String[]{"D", "A", "TO_START_POINT"});
        list.add(new String[]{"C", "A", "TO_START_POINT"});

        Gson gson = new GsonBuilder().create();

        String str = gson.toJson(list);

        System.out.print(str);
    }*/

}
