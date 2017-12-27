/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.vtb.dbo.state.domain.EDoc;
import ru.vtb.dbo.state.domain.Machine;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;
import ru.vtb.dbo.state.service.CreateMachineService;
import java.util.Map;

/**
 * @author Olga_Zlobina
 */
@Controller
@Profile("ifelse")
public class LcController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Map<Long, Machine> machineForDocType;

    @Autowired
    private CreateMachineService createMachineService;

    @Autowired
    private Map<Long, StateMachine<States, Events>> currentMachines;

    @RequestMapping(value = "lc/create/{docTypeId}", method = RequestMethod.POST)
    @ResponseBody
    public void createDoctypeLc(@PathVariable Long docTypeId, @RequestBody Machine machine){
        machineForDocType.put(docTypeId, machine);
    }



    @RequestMapping(value = "machine/create", method = RequestMethod.POST)
    @ResponseBody
    public void createDocMachine(@RequestBody EDoc eDoc) throws Exception {
        StateMachine<States, Events> machine = createMachineService
                .createMachine(machineForDocType.get(eDoc.getDocTypeId()).getMachine().values());

        machine.start();
        machine.getExtendedState().getVariables().put("edoc", eDoc);
        machine.sendEvent(Events.START);
        currentMachines.put(eDoc.getId(), machine);

    }

    @RequestMapping(value = "machine/start}", method = RequestMethod.GET)
    @ResponseBody
    public void startDocLc(@RequestBody EDoc eDoc) throws Exception {
        StateMachine<States, Events> machine =  currentMachines.get(eDoc.getId());


        machine.getExtendedState().getVariables().put("id", eDoc.getId());

        machine.getExtendedState().getVariables().put("eventActionId",
                machineForDocType.get(eDoc.getDocTypeId()).getMachine().get(0).getEventActionId());
        machine.start();
        machine.sendEvent(Events.START);
        runMachine(machine);

    }


    @RequestMapping(value = "machine/send/event/{eventId}}", method = RequestMethod.GET)
    @ResponseBody
    public void startDocLc(@PathVariable String eventId, @RequestBody EDoc eDoc) throws Exception {

        StateMachine<States, Events> machine =  currentMachines.get(eDoc.getId());

        machine.sendEvent(Events.valueOf(eventId));
        runMachine(machine);

    }

    private void runMachine(StateMachine<States, Events> machine) {
        Events event = null;
        while (event != null){
            event =machine.getExtendedState().get("nextEvent", Events.class);
            machine.sendEvent(event);
        }
    }
}
