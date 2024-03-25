package org.patterns.generative;

import org.junit.jupiter.api.Test;

class PersonalComputerBuilderTest {

    @Test
    void test_build() {
        try {
            PersonalComputer personalComputer = new PersonalComputerBuilder()
                    .setMotherboard(new Motherboard(
                            CpuBrand.AMD, "Titan - B450", MemoryType.DDR3
                    ))
                    .setMemory(new Memory(
                            32, MemoryType.DDR3
                    ))
                    .setCPU(new CPU(
                            CpuBrand.AMD, 4500.0, 6
                    ))
                    .build();
            System.out.println(personalComputer);
        } catch (IncompatablePartsException | IncompleteBuildException e) {
            System.out.println(e);
        }
    }

}