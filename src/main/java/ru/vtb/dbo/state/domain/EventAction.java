package ru.vtb.dbo.state.domain;

import ru.vtb.dbo.state.enums.Events;

/**
 * @author Olga_Zlobina
 */
public interface EventAction {

    Events nextEvent(EDoc eDoc);
}
