package ru.vtb.dbo.state.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

import java.util.EnumSet;

/**
 * @author Olga_Zlobina
 */
@Configuration
@Profile("simple")
@EnableStateMachine
public class MachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.A)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.A).target(States.B)
                .event(Events.SAVE_DRAFT)
                .and()
                .withExternal()
                .source(States.B).target(States.C)
                .event(Events.GET_SIGNATURE)
                .and()
                .withExternal()
                .source(States.B).target(States.D)
                .event(Events.HAS_ERROR)
                .and()
                .withExternal()
                .source(States.D).target(States.A)
                .event(Events.TO_START_POINT)
                .and()
                .withExternal()
                .source(States.C).target(States.A)
                .event(Events.TO_START_POINT)
        ;
    }
}