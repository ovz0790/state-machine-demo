package ru.vtb.dbo.state.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author Olga_Zlobina
 */
@Getter
@Setter
public class Machine {
    private Map<PassKey, Pass> machine;
    private Long docType;
}
