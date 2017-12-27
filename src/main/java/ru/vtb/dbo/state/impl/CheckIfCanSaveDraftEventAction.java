
package ru.vtb.dbo.state.impl;

import ru.vtb.dbo.state.domain.EventAction;
import ru.vtb.dbo.state.enums.Events;

/**
 * @author Olga_Zlobina
 */
public class CheckIfCanSaveDraftEventAction implements EventAction{
    @Override
    public Events nextEvent() {
        return Events.SAVE_DRAFT;
    }
}
