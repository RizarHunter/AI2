public class Neuron {
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

    Neuron[] parent;
    Neuron[] child;

}