
/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state.impl;

import ru.vtb.dbo.state.domain.EDoc;
import ru.vtb.dbo.state.domain.EventAction;
import ru.vtb.dbo.state.enums.Events;

/**
 * @author Olga_Zlobina
 */
public class CheckIfCanSignatureEventAction implements EventAction{
    @Override
    public Events nextIvent(EDoc eDoc) {
        return Events.GET_SIGNATURE;
    }
}
