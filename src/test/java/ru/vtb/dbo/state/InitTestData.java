/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state;

import ru.vtb.dbo.state.domain.Machine;
import ru.vtb.dbo.state.domain.Path;
import ru.vtb.dbo.state.domain.PathKey;
import ru.vtb.dbo.state.enums.Events;
import ru.vtb.dbo.state.enums.States;

import javax.swing.plaf.nimbus.State;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Olga_Zlobina
 */
public class InitTestData {

    public static void main(String[] args){
        Machine machine = new Machine().setDocType(1L);
        Map<PathKey, Path> map = new HashMap<>();
        {
            PathKey pk = new PathKey(States.START, States.STARTED_LC, Events.START_LC);
            map.put(pk, new Path().setPathKey(pk).setEventActionId("checkIfCanSaveDraftEventAction"));
        }
        {
            PathKey pk = new PathKey(States.STARTED_LC, States.DRAFT, Events.SAVE_DRAFT);
            map.put(pk, new Path().setPathKey(pk).setEventActionId("checkIfCanSignatureEventAction"));
        }
        {
            PathKey pk = new PathKey(States.DRAFT, States.SIGNATURED,  Events.GET_SIGNATURE);
            map.put(pk, new Path().setPathKey(pk).setEventActionId("stopAndWaitEventAction"));
        }

///next graph peace
        {
            PathKey pk = new PathKey(States.SIGNATURED, States.PROCESSED, Events.PROCESS_DOC);
            map.put(pk, new Path().setPathKey(pk).setEventActionId("checkIfCanSignatureAgainEventAction"));
        }
        {
            PathKey pk = new PathKey(States.PROCESSED, States.SIGNATURED1, Events.GET_SIGNATURE);
            map.put(pk, new Path().setPathKey(pk).setEventActionId("stopAndWaitEventAction"));
        }
    }
}
