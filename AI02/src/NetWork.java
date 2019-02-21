import java.util.LinkedList;

public class NetWork {
    //region static
    private static void compound(Neuron parent, Neuron child, Axon axon){
        parent.addAxonOutput(axon);
        child.addAxonInput(axon);
    }
    //endregion
    //region fields
    LinkedList<Axon> axons;
    Neuron[][] neurons;
    //endregion
    //region construct
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

        for (int i = 0; i < neurons.length - 1; i++) {
            for (int j = 0; j < neurons[i].length; j++) {
                for (int k = 0; k < neurons[i + 1].length; k++) {
                    if (k == neurons[i + 1].length - 1)
                        continue;
                    else
                        connect(neurons[i][j], neurons[i + 1][k]);
                }
            }
        }

        connect(neurons[0][0], neurons[1][0]);
    }
    private void connect(Neuron parent, Neuron child){
        Axon axon = new Axon(parent, child);
        compound(parent, child, axon);
        axons.add(axon);
    }
    //endregion

    public void update(){

    }
    public void getData(){

    }
}
