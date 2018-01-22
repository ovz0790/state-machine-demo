package ru.demo.state.machine.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.statemachine.StateMachine;
import ru.demo.state.machine.domain.DefineNextEventAction;
import ru.demo.state.machine.domain.Machine;
import ru.demo.state.machine.enums.Events;
import ru.demo.state.machine.enums.States;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Olga_Zlobina
 */
@Configuration
public class AppConfig {


    @Bean
    public Map<Long, Machine> machineForDocType(){
        final ConcurrentMap<Long, Machine> machines = new ConcurrentHashMap<>();
        return machines;
    }

    @Bean
    public Map<Long, StateMachine<States, Events>> currentMachines(){
        final ConcurrentMap<Long, StateMachine<States, Events>> machines = new ConcurrentHashMap<>();
        return machines;
    }

    @Bean
    @Scope("prototype")
    public DefineNextEventAction action(){
        return new DefineNextEventAction();
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
