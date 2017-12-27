package ru.vtb.dbo.state.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Olga_Zlobina
 */
@Getter
@Setter
public class Machine {
    private List<Path> machine;
    private Long docType;
}
