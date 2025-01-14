package animals.robots;

import animals.Pet;
import animals.Robot;

public class RoboDog extends Robot implements Pet {

    private boolean isCharged;

    public RoboDog(String model) {
        super(model);

        this.isCharged = true;
    }

    @Override
    public void play() {
        if (this.isCharged) {
            System.out.printf("%s plays fetch.%n", this.getModel());
            this.isCharged = false;
        } else {
            System.out.printf("%s cannot play while discharged.%n", this.getModel());
        }
    }

    @Override
    public void performTask() {
        if (this.isCharged) {
            System.out.printf("%s is guarding the house.%n", this.getModel());
            this.isCharged = false;
        } else {
            System.out.printf("%s cannot guard the house while discharged.%n", this.getModel());
        }
    }

    public boolean isCharged() {
        return this.isCharged;
    }

    public void charge() {
        this.isCharged = true;
    }
}
