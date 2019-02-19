public class Axon {
    double wight = 0.5f;
    Neuron start = null;
    Neuron finish = null;

    public Axon(double wight, Neuron start, Neuron finish) {
        this.wight = wight;
        this.start = start;
        this.finish = finish;
    }

    public Axon(Neuron start, Neuron finish) {
        this.start = start;
        this.finish = finish;
    }

    public void transmitData(double data){
        if (finish != null){
            finish.addInput(data * wight);
        }
    }
}
