
/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state.impl;

import org.springframework.stereotype.Service;
import ru.vtb.dbo.state.domain.EDoc;
import ru.vtb.dbo.state.domain.EventAction;
import ru.vtb.dbo.state.enums.Events;

/**
 * @author Olga_Zlobina
 */
@Service
public class CheckIfCanSignatureEventAction implements EventAction{
    @Override
    public Events nextEvent(EDoc eDoc) {
        return Events.GET_SIGNATURE;
    }
}
