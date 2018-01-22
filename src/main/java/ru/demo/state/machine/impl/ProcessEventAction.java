package ru.demo.state.machine.impl;

import org.springframework.stereotype.Service;
import ru.demo.state.machine.enums.Events;
import ru.demo.state.machine.domain.EDoc;
import ru.demo.state.machine.domain.EventAction;

/**
 * @author Olga_Zlobina
 */
@Service
public class ProcessEventAction implements EventAction{
    @Override
    public Events nextEvent(EDoc eDoc) {
        return Events.PROCESS_DOC;
    }
}
