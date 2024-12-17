package de.tanschmi.aoc2024.dec17;

public class Dec17 {
    private ChronospatialComputer computer;
    StringBuilder out;

    public String task1(ChronospatialComputer computer) {

        this.computer = computer;
        this.out = new StringBuilder();

        while (computer.pointer < computer.program.size()) {
            process();
        }
        return out.toString();
    }

    private void process() {
        int opcode = computer.program.get(computer.pointer);
        int operand = computer.program.get(computer.pointer + 1);
        try {
            switch (opcode) {
                case 0:
                    adv_0(operand);
                    break;
                case 1:
                    bxl_1(operand);
                    break;
                case 2:
                    bst_2(operand);
                    break;
                case 3:
                    jnz_3(operand);
                    break;
                case 4:
                    bxc_4(operand);
                    break;
                case 5:
                    out_5(operand);
                    break;
                case 6:
                    bdv_6(operand);
                    break;
                case 7:
                    cdv_7(operand);
                    break;
            }
            computer.pointer = computer.pointer + 2;
        } catch (NotIncreasePointer e) {
            //do not change pointer
        }
    }

    void adv_0(Integer operand) {

        int i = getOperand(operand);
        int result = computer.registerA / ((int) Math.pow(2, i));
        computer.registerA = result;
    }

    void bxl_1(Integer operand) {
        int result = computer.registerB ^ operand;
        computer.registerB = result;
    }

    void bst_2(Integer operand) {
        int result = getOperand(operand) % 8;
        computer.registerB = result;
    }

    void jnz_3(Integer operand) throws NotIncreasePointer {
        if (computer.registerA != 0) {
            computer.pointer = operand;
            throw new NotIncreasePointer();
        }
    }

    void bxc_4(Integer operand) {
        computer.registerB ^= computer.registerC;
    }

    void out_5(Integer operand) {
        boolean empty = out.isEmpty();
        int result = getOperand(operand) % 8;
        if (!empty) {
            out.append(",");
        }
        out.append(result);


    }

    void bdv_6(Integer operand) {
        int i = getOperand(operand);
        int result = computer.registerA / ((int) Math.pow(2, i));
        computer.registerB = result;
    }

    void cdv_7(Integer operand) {
        int i = getOperand(operand);
        int result = computer.registerA / ((int) Math.pow(2, i));
        computer.registerC = result;
    }

    int getOperand(Integer operand) {
        return switch (operand) {
            case 0, 1, 2, 3 -> operand;
            case 4 -> computer.registerA;
            case 5 -> computer.registerB;
            case 6 -> computer.registerC;
            default -> throw new IllegalArgumentException("Not used in valid programs");
        };
    }
}
