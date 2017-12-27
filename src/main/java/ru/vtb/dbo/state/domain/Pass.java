package ru.vtb.dbo.state.domain;

import lombok.Getter;
import lombok.Setter;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

/**
 * @author Olga_Zlobina
 */
@Getter
@Setter
public class Pass {
    private States stateFrom;
    private States stateTo;

    /**
     * define if need to move external
     */
    private Events event;

    /**
     * define for get internal moving
     */
    private String eventActionId;
}