import java.util.LinkedList;

public class Neuron {
    //region static
    public static double findNormal(double input){
        return findNormalSigmoid(input);
    }
    public static double findNormalSigmoid(double input){
        return 1/(1 - Math.exp(-input));
    }
    public static double findNormalLine(double input){
        return input;
    }
    public static double findNormalHiper(double input){
        return (Math.exp(2*input)-1)/(Math.exp(2*input)+1);
    }
    //endregion

    LinkedList<Axon> axonInput;
    LinkedList<Axon> axonOutput;

    double input;
    double output;

    boolean isInputEqualOutput;

    public Neuron() {
        this.axonInput = new LinkedList<>();
        this.axonOutput = new LinkedList<>();
        this.input = 0;
        this.output = 0;
        this.isInputEqualOutput = false;
    }

    public void addAxonInput(Axon axon){
        axonInput.add(axon);
    }
    public void addAxonOutput(Axon axon){
        axonOutput.add(axon);
    }

    public void setInputOutput(double data){
        this.input = this.output = data;
        isInputEqualOutput = true;
    }
    public void addInput(double data){
        this.input += data;
        isInputEqualOutput = false;
    }

    public void update() {
        calculateData();
        sendDataToNextLayer();
    }
    public void calculateData(){
        if (!isInputEqualOutput) {
            this.output = findNormal(this.input);
            this.input = 0;
        }
    }
    public void sendDataToNextLayer(){
        for (int i = 0; i < axonOutput.size(); i++) {
            axonOutput.get(i).transmitData(output);
        }
    }
}