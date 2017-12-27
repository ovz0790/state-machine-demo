/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state.domain;

        import ru.vtb.dbo.state.enums.Events;

/**
 * @author Olga_Zlobina
 */
public interface MachineAction {
    Events nextIvent();
}
