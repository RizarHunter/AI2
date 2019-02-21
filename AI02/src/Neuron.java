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

    String name;

    public Neuron() {
        this.axonInput = new LinkedList<>();
        this.axonOutput = new LinkedList<>();
        this.input = 0;
        this.output = 0;
        this.isInputEqualOutput = false;
        this.name = "";
    }
    public Neuron(String name) {
        this();
        this.name = name;
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
    public Neuron[] getConnectionList(){
        Neuron[] neurons = new Neuron[axonOutput.size()];
        for (int i = 0, len = axonOutput.size(); i < len; i++) {
            neurons[i] = axonOutput.get(i).finish;
        }
        return neurons;
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