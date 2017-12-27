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
    private Map<Long, Machine> machineForDocType;

    @Autowired
    private Map<Long, StateMachine<States, Events>> currentMachines;

    @Override
    public void execute(StateContext<States, Events> stateContext) {

        Long docTypeId = stateContext.getExtendedState().get("docTypeId", Long.class);
        EDoc eDoc =  stateContext.getExtendedState().get("edoc", EDoc.class);
        PathKey pk = new PathKey(stateContext.getSource().getId(), stateContext.getTarget().getId(), stateContext.getEvent());
        String beanId = machineForDocType.get(docTypeId).getMachine().get(pk).getEventActionId();
        EventAction action = (EventAction)applicationContext.getBean(beanId);
        currentMachines.get(eDoc.getId()).getExtendedState().getVariables().put("nextEvent", action.nextEvent(eDoc));

    }
}
