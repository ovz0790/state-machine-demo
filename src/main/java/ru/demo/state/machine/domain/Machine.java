package ru.demo.state.machine.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author Olga_Zlobina
 */
@Getter
@Setter
@Accessors(chain = true)
public class Machine {
    private Map<PathKey, Path> machine;
    private Long docType;
}
