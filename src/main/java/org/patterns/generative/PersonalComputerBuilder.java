package org.patterns.generative;

import lombok.*;

class IncompatablePartsException extends Exception {

    public IncompatablePartsException(String message) {
        super(message);
    }
}

class IncompleteBuildException extends Exception {
}


enum CpuBrand {
    AMD,
    Intel,
    VIA
}

enum MemoryType {
    DDR1,
    DDR2,
    DDR3,
    DDR4,
    DDR5
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Memory {
    private int amountInGB;
    private MemoryType memoryType;
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class CPU {
    private CpuBrand brand;
    private double frequency;
    private int coresCount;
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Motherboard {
    private CpuBrand brand;
    private String model;
    private MemoryType memoryType;
}

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class PersonalComputer {
    private CPU cpu;
    private Memory memory;
    private Motherboard motherboard;
}

/**
 * PersonalComputerBuilder - созидательный паттерн проектирования в котором вся сложная логика создания класса
 * энкапсулируется в класс-строитель. Зачастую легче всего воспользоваться конструктором, данный паттерн чаще всего
 * встречается при создании SQL-запросов и в unit-тестах.
 *
 * <p>
 * В данном случае мы воспользовались данным паттерном для удобной проверки на совместимость деталей при добавлении
 * их в компьютер.
 * </p>
 */
public class PersonalComputerBuilder {
    private final PersonalComputer personalComputer = new PersonalComputer();

    public PersonalComputerBuilder setCPU(CPU cpu) throws IncompatablePartsException {
        Motherboard motherboard = personalComputer.getMotherboard();
        if (personalComputer.getMotherboard() == null) {
            personalComputer.setCpu(cpu);
            return this;
        }
        if (personalComputer.getMotherboard().getBrand() != cpu.getBrand()) {
            throw new IncompatablePartsException("Wrong cpu brand, wanted %s, got %s".formatted(
                    personalComputer.getMotherboard().getBrand(), cpu.getBrand()
            ));
        }
        personalComputer.setCpu(cpu);
        return this;
    }

    public PersonalComputerBuilder setMemory(Memory memory) throws IncompatablePartsException {
        Motherboard motherboard = personalComputer.getMotherboard();
        if (motherboard == null) {
            personalComputer.setMemory(memory);
            return this;
        }
        if (motherboard.getMemoryType() != memory.getMemoryType()) {
            throw new IncompatablePartsException("Wrong memory type, wanted %s, got %s".formatted(
                    motherboard.getMemoryType(), memory.getMemoryType()
            ));
        }
        personalComputer.setMemory(memory);
        return this;
    }

    public PersonalComputerBuilder setMotherboard(Motherboard motherboard) throws IncompatablePartsException {
        CPU cpu = personalComputer.getCpu();
        Memory memory = personalComputer.getMemory();
        if (cpu != null) {
            if (cpu.getBrand() != motherboard.getBrand()) {
                throw new IncompatablePartsException("Motherboard and processor does not match");
            }
        }
        if (memory != null) {
            if (memory.getMemoryType() != motherboard.getMemoryType()) {
                throw new IncompatablePartsException("Motherboard and processor does not match");
            }
        }
        personalComputer.setMotherboard(motherboard);
        return this;
    }

    public PersonalComputer build() throws IncompleteBuildException {
        if (personalComputer.getCpu() == null ||
                personalComputer.getMemory() == null ||
                personalComputer.getMotherboard() == null) {
            throw new IncompleteBuildException();
        }
        return personalComputer;
    }
}
