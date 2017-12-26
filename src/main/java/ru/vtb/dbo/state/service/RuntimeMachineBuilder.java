package ru.vtb.dbo.state.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.stereotype.Service;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/**
 * @author Olga_Zlobina
 */
@Service
@Slf4j
public class RuntimeMachineBuilder {
    @Autowired
    Map<Long, StateMachine<States, Events>> machine;

    public void buildMachineWithGraph(Long docTypeId, List<String[]> graph) throws Exception {
        StateMachine<States, Events> sm = buildMachine(graph);
        sm.start();
        machine.put(docTypeId, sm);
    }

    public StateMachine<States, Events> buildMachine(List<String[]> graph) throws Exception {
        final StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

        builder.configureStates()
                .withStates()
                .initial(States.A)
                .states(EnumSet.allOf(States.class));
        final StateMachineTransitionConfigurer<States, Events> configureTransitions = builder.configureTransitions();

        graph.forEach(gr -> {
                    try {
                        configureTransitions
                                .withExternal()
                                .source(States.valueOf(gr[0])).target(States.valueOf(gr[1]))
                                .event(Events.valueOf(gr[2]))
                                .and();
                    } catch (Exception e) {
                        log.error("ERROR:", e);
                    }
                }
        );
        return builder.build();
    }

    public States sendEvent(Long docTypeId, Events event){
        StateMachine<States, Events> docMachine = machine.get(docTypeId);

        docMachine.sendEvent(event);
        return docMachine.getState().getId();
    }

}
