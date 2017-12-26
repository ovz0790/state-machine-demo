package ru.vtb.dbo.state.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;
import ru.vtb.dbo.state.service.RuntimeMachineBuilder;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Olga_Zlobina
 */
@Controller
@Profile("ifelse")
public class TestElseIfController {
    @Autowired
    StateMachine<States, Events> stateMachine;

    @Autowired
    RuntimeMachineBuilder runtimeMachineBuilder;

    @PostConstruct
    public void initMachine(){
        stateMachine.start();
    }


    @RequestMapping(value = "change/var/{var}", method = RequestMethod.GET)
    @ResponseBody
    public void sendEvent(@PathVariable Integer var){
        stateMachine.getExtendedState().getVariables()
                .put("definedVar", var);
    }
    @RequestMapping(value = "get/state", method = RequestMethod.GET)
    @ResponseBody
    public States getState(){

        return stateMachine.getState().getId();
    }


    @RequestMapping(value = "send/event/{eventId}", method = RequestMethod.GET)
    @ResponseBody
    public States sendEvent(@PathVariable String eventId){
        stateMachine.sendEvent(Events.valueOf(eventId));

        return stateMachine.getState().getId();
    }

}
