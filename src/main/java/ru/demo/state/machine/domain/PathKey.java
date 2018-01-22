package ru.demo.state.machine.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.demo.state.machine.enums.Events;
import ru.demo.state.machine.enums.States;

/**
 * @author Olga_Zlobina
 */
@Getter
@AllArgsConstructor
public class PathKey {
    private final States stateFrom;
    private final States stateTo;

    /**
     * define if need to move external
     */
    private final Events event;
}
