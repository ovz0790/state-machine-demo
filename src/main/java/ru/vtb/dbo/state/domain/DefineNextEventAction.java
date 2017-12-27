package ru.vtb.dbo.state.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

import java.util.Map;

/**
 * @author Olga_Zlobina
 */
public class DefineNextEventAction implements Action<States, Events> {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Map<Long, StateMachine<States, Events>> currentMachines;

    @Override
    public void execute(StateContext<States, Events> stateContext) {
        String beanId = stateContext.getExtendedState().get("eventActionId", String.class);

        Long machineId =  stateContext.getExtendedState().get("id", Long.class);

        EventAction action = (EventAction)applicationContext.getBean(beanId);

        currentMachines.get(machineId).getExtendedState().getVariables().put("nextEvent", action.nextEvent());
    }
}
