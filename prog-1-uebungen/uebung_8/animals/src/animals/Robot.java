package animals;

public abstract class Robot {

    private String model;

    public abstract void performTask();

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
