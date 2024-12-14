package de.tanschmi.aoc2024.dec14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Robot {

    int initialX;
    int initialY;
    int velocityX;
    int velocityY;

    int currentX;
    int currentY;

    public Robot(int initialX, int initialY, int velocityX, int velocityY) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;

        this.currentX = initialX;
        this.currentY = initialY;
    }

    public void moveWithinBounds(final int WIDTH, final int HEIGHT) {
        currentX += velocityX;
        currentY += velocityY;

        if (currentX >= WIDTH) {
            currentX = currentX % WIDTH;
        }
        if (currentX < 0) {
            currentX += WIDTH;
        }
        if (currentY >= HEIGHT) {
            currentY = currentY % HEIGHT;
        }
        if (currentY < 0) {
            currentY += HEIGHT;
        }

    }

}
