package ru.vtb.dbo.state.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author Olga_Zlobina
 */
@WithStateMachine
@Slf4j
public class ActionHandler {
    @OnTransition(target = "A")
    public void whileSaveDraft() {
        log.info("SAVING DOC DRAFT");
    }

    @OnTransition(target = "B")
    public void whileGettingSignature() {
        log.info("GETTING SIGNATURE");
    }
}
