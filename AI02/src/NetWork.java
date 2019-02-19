import java.util.LinkedList;

public class NetWork {
    public static void compound(Neuron parent, Neuron child, Axon axon){
        parent.addAxonOutput(axon);
        child.addAxonInput(axon);
    }

    LinkedList<Axon> axons = new LinkedList<>();
    Neuron[][] neurons;

    public NetWork() {
        axons = new LinkedList<>();

        neurons = new Neuron[3][];
        neurons[0] = new Neuron[3];
        neurons[1] = new Neuron[3];
        neurons[2] = new Neuron[1];

        for (int i = 0; i < neurons.length; i++) {
            for (int j = 0; j < neurons[i].length; j++) {
                neurons[i][j] = new Neuron();
            }
        }
    }
    public void update(){

    }
    public void getData(){

    }
}
