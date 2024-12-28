package de.tanschmi.aoc2024.dec9;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

@Slf4j
public class Dec9 {

    long task1(String input) {

        ArrayList<DiskItem> disk = getDisc(input);

        int ptrLast = disk.size() - 1;
        int ptrFree = 0;
        while (ptrLast > ptrFree) {
            DiskItem last = disk.get(ptrLast);
            while (ptrFree < disk.size()) {
                DiskItem free = disk.get(ptrFree);
                if (!free.isEmpty) {
                    ptrFree++;
                    continue;
                } else {
                    int sizeIdToMove = last.size;
                    int freeSize = free.size;

                    if (sizeIdToMove <= freeSize) {
                        DiskItem newItem = new DiskItem(last.id, sizeIdToMove);
                        free.size = free.size - sizeIdToMove;
                        disk.add(ptrFree, newItem);
                        disk.remove(last);
                        ptrLast--;
                        break;
                    } else {
                        DiskItem newItem = new DiskItem(last.id, freeSize);
                        last.size = last.size - freeSize;
                        disk.add(ptrFree, newItem);
                        disk.remove(free);
                    }
                }
            }

        }
        System.out.println(printDisk(disk));

        long result = calcChecksum(disk);

        return result;
    }

    long task2(String input) {
        ArrayList<DiskItem> disk = getDisc(input);

        int ptrLast = disk.size() - 1;

        while (ptrLast > 0) {
            DiskItem last = disk.get(ptrLast);
            if (last.isEmpty) {
                ptrLast--;
                continue;
            }
            int ptrFree = 0;
            while (ptrFree < disk.size() && ptrFree < ptrLast) {
                DiskItem free = disk.get(ptrFree);
                if (!free.isEmpty) {
                    ptrFree++;
                    continue;
                }
                int sizeIdToMove = last.size;
                int freeSize = free.size;
                if (sizeIdToMove <= freeSize) {
                    DiskItem newItem = new DiskItem(last.id, sizeIdToMove);
                    free.size = free.size - sizeIdToMove;
                    disk.add(ptrFree, newItem);
                    last.isEmpty = true;
                    last.id = null;

                    if (free.size == 0) {
                        disk.remove(free);
                        //System.out.println(printDisk(disk));
                    }
                    break;
                } else {
                    ptrFree++;
                }

            }
            ptrLast--;
           // System.out.println(printDisk(disk));
        }
        System.out.println(printDisk(disk));

        long result = calcChecksum(disk);

        return result;

    }

    String printDisk(ArrayList<DiskItem> disk) {
        StringBuilder builder = new StringBuilder();
        for (DiskItem item : disk) {
            if (item.isEmpty) {
                builder.append(StringUtils.repeat('.', item.size));
            } else {
                builder.append(StringUtils.repeat(item.id.toString(), item.size));
            }
        }
        return builder.toString();
    }

    private long calcChecksum(ArrayList<DiskItem> disk) {
        long sum = 0;
        long index = 0;
        for (int i = 0; i < disk.size(); i++) {
            DiskItem item = disk.get(i);

            if (!item.isEmpty && item.id != null) {

                for (int j = 0; j < item.size; j++) {
                    sum += index++ * item.id;
                }

            } else {
                index += item.size;
            }
        }
        return sum;
    }

    ArrayList<DiskItem> getDisc(String input) {
        char[] chars = input.toCharArray();

        ArrayList<DiskItem> disk = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < chars.length; i++) {

            int size = Integer.parseInt("" + chars[i]);
            if (i % 2 == 0) {
                disk.add(new DiskItem(id++, size));
            } else {
                disk.add(new DiskItem(size));
            }
        }
        return disk;
    }
}

class DiskItem {
    boolean isEmpty = false;
    int size;
    Integer id = null;

    public DiskItem(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public DiskItem(int size) {
        this.isEmpty = true;
        this.size = size;
    }

    @Override
    public String toString() {
        if (isEmpty) {
            return "empty(" + size + ")";
        } else {
            return "id" + id + "(" + size + ")";
        }
    }
}