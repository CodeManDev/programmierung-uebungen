package animals;

public abstract class Robot {

    private String model;

    public Robot(String model) {
        this.model = model;
    }

    public abstract void performTask();

    public String getModel() {
        return this.model;
    }
}
