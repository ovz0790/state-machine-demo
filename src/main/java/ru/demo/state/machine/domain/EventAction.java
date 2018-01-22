package ru.demo.state.machine.domain;

import ru.demo.state.machine.enums.Events;

/**
 * @author Olga_Zlobina
 */
public interface EventAction {

    Events nextEvent(EDoc eDoc);
}
