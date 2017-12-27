/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

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
