package OOP._1_WorkingWithAbstraction.ex_4_TrafficLights;

public class TrafficLight {

    private Colors currentColor;

    public TrafficLight(Colors color) {
        this.currentColor = color;
    }

    public Colors getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Colors currentColor) {
        this.currentColor = currentColor;
    }

    public void changeColor() {

        switch (currentColor) {
            case RED:
                this.currentColor = Colors.GREEN;
                break;

            case GREEN:
                this.currentColor = Colors.YELLOW;
                break;

            case YELLOW:
                this.currentColor = Colors.RED;
                break;
        }
    }
}
