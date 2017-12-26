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
import java.util.Map;

/**
 * @author Olga_Zlobina
 */
@Controller
@Profile("simple")
public class MachineController {
    @Autowired
    StateMachine<States, Events> stateMachine;

    @Autowired
    RuntimeMachineBuilder runtimeMachineBuilder;

    @PostConstruct
    public void initMachine(){
        stateMachine.start();
    }

    @RequestMapping(value = "send/event/{eventId}", method = RequestMethod.POST)
    @ResponseBody
    public States sendEvent(@PathVariable String eventId){
        stateMachine.sendEvent(Events.valueOf(eventId));

        return stateMachine.getState().getId();
    }

    @RequestMapping(value = "send/event/init", method = RequestMethod.GET)
    @ResponseBody
    public States init(){
        stateMachine.start();
        return stateMachine.getState().getId();
    }

    @RequestMapping(value = "add/graph/{docTypeId}", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void sendEvent(@PathVariable Long docTypeId, @RequestBody List<String[]> graph) throws Exception {
        runtimeMachineBuilder.buildMachineWithGraph(docTypeId, graph);
    }

    @RequestMapping(value = "send/docevent/{docTypeId}/{eventId}", method = RequestMethod.GET)
    @ResponseBody
    public States sendEvent(@PathVariable Long docTypeId,@PathVariable String eventId) throws Exception {
        return runtimeMachineBuilder.sendEvent(docTypeId, Events.valueOf(eventId));
    }

}
