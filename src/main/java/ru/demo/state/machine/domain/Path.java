package ru.demo.state.machine.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Olga_Zlobina
 */
@Getter
@Setter
@Accessors(chain = true)
public class Path {
    private PathKey pathKey;

    /**
     * define for get internal moving
     */
    private String eventActionId;

}