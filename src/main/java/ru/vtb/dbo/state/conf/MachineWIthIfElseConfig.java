/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

import java.util.EnumSet;

/**
 * @author Olga_Zlobina
 */
@Configuration
@EnableStateMachine
@Profile("ifelse")
public class MachineWIthIfElseConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


    @Bean
    public Guard<States, Events> defineMove() {
        return ctx -> {
            int var = (int) ctx.getExtendedState().getVariables()
                    .getOrDefault("definedVar", 0);

            return var == 1;
        };
    }

    @Bean
    public Guard<States, Events> defineMove1() {
        return ctx -> {
            int var = (int) ctx.getExtendedState().getVariables()
                    .getOrDefault("definedVar", 0);

            return var == 2;
        };
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.A)
                .states(EnumSet.allOf(States.class))
                .junction(States.B)
        ;
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.A).target(States.B)
                .event(Events.SAVE_DRAFT)
                .and()
                .withJunction()
                .source(States.B)
                .first(States.C, defineMove())
                .then(States.D, defineMove1())
                .last(States.E)
                .and()
                .withExternal()
                .source(States.E).target(States.A)
                .event(Events.TO_START_POINT)
                .and()
                .withExternal()
                .source(States.C).target(States.A)
                .event(Events.TO_START_POINT)
                .and()
                .withExternal()
                .source(States.D).target(States.A)
                .event(Events.TO_START_POINT)
        ;
    }
}