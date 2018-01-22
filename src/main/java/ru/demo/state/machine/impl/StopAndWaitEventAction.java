package ru.demo.state.machine.impl;

import org.springframework.stereotype.Service;
import ru.demo.state.machine.domain.EDoc;
import ru.demo.state.machine.domain.EventAction;
import ru.demo.state.machine.enums.Events;

/**
 * @author Olga_Zlobina
 */
@Service
public class StopAndWaitEventAction implements EventAction{
    @Override
    public Events nextEvent(EDoc eDoc) {
        return null;
    }
}
