package org.patterns.structuring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerFacadeTest {

    @Test
    void startComputer() {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}