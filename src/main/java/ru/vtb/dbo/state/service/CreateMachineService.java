package ru.vtb.dbo.state.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.stereotype.Service;
import ru.vtb.dbo.state.domain.DefineNextEventAction;
import ru.vtb.dbo.state.domain.Pass;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

import java.util.Collection;
import java.util.EnumSet;

/**
 * @author Olga_Zlobina
 */
@Service
@Slf4j
public class CreateMachineService {

    @Autowired
    private DefineNextEventAction action;

    public StateMachine<States, Events> createMachine(Collection<Pass> machine) throws Exception {
        final StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

            builder.configureStates()
                    .withStates()
                    .initial(States.START_LC)
                    .states(EnumSet.allOf(States.class));

        final StateMachineTransitionConfigurer<States, Events> configureTransitions = builder.configureTransitions();
        machine.forEach(
                pass -> {
                    try {
                        configureTransitions
                                .withExternal()
                                .source(pass.getPassKey().getStateFrom()).target(pass.getPassKey().getStateTo())
                                .event(pass.getPassKey().getEvent())
                                .action(action)
                                .and();
                    } catch (Exception e) {
                        log.error("ERROR:", e);
                    }
                });

        return builder.build();
    }
}
