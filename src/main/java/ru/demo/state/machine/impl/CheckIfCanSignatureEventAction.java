package ru.demo.state.machine.impl;

import org.springframework.stereotype.Service;
import ru.demo.state.machine.domain.EventAction;
import ru.demo.state.machine.enums.Events;
import ru.demo.state.machine.domain.EDoc;

/**
 * @author Olga_Zlobina
 */
@Service
public class CheckIfCanSignatureEventAction implements EventAction {
    @Override
    public Events nextEvent(EDoc eDoc) {
        return Events.GET_SIGNATURE;
    }
}
