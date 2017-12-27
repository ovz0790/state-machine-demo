/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state.domain;

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
