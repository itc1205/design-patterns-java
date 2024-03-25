package org.patterns.structuring;

import java.util.Arrays;

class CPU {
    public void execute() {
        System.out.println("CPU has been executed some instruction");
    }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.printf("Memory loaded by the address: %d %s\n", position, Arrays.toString(data));
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        return "Hello, world.\n\txoxo: HardDrive".getBytes();
    }
}

/**
 * ComputerFacade - пример структурного паттерна проектирования "Фасад"
 * для класса который создает абстракцию над сложной логикой, предоставляя простой интерфейс
 * <p>
 * В данном случае мы обернули сложную логику запуска компьютера в простой и удобный класс.
 * </p>
 * <p>
 * С помощью данного паттерна удобно объединять логику работы нескольких классов в что-то общее.
 * </p>
 */
public class ComputerFacade {
    private final long BOOT_ADDRESS = 0x000;
    private final long BOOT_SECTOR = 0x010;
    private final int SECTOR_SIZE = 0x010;

    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final HardDrive hardDrive = new HardDrive();

    public void startComputer() {
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.execute();
    }
}
