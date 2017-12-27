package ru.vtb.dbo.state.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Olga_Zlobina
 */
@Getter
@Setter
public class Pass {
    private PassKey passKey;

    /**
     * define for get internal moving
     */
    private String eventActionId;
}