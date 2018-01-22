package ru.demo.state.machine.domain;

import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 * @author Olga_Zlobina
 */
@Getter
@Service
public class EDoc {
    private Long id;
    private Long docTypeId;
    private Long amount;
    private String account;
    private String docTypeDescription;
}
