import java.util.Random;

public class SearchAlgorithms {
    
    public static int [] buildVector (int length) {
        
        Random r = new Random();
        
        int [] vector = new int [length];

        for (int i = 0; i < length; i++) {
            vector[i] = r.nextInt(31);
        }

        return vector;
    }

    public static void showVector (int [] vector) {
        
        System.out.println("Seu vetor é:\n");

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + "\t");
        }
        System.out.println("\n");
    }

    public static int [] organizingVector (int [] vector) {
        
        int [] organizedVector = new int [vector.length];

        int index = 0;
        
        do {
            int smallest = Integer.MAX_VALUE;

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] < smallest) {
                    smallest = vector[i];
                }
            }

            vector[linearSearch(vector, smallest)] = Integer.MAX_VALUE;

            organizedVector[index] = smallest;

            index++;
        } while (index < vector.length);

        return organizedVector;
    }

    public static int linearSearch (int [] vector, int key) {

        int i;

        boolean found = false;

        for (i = 0; i < vector.length; i++) {
            if (key == vector[i]) {
                found = true;
                
                break;
            }
        }

        if (found) {
            return i;
        } else {
            return -1;
        }
    }

    // public static int improvedLinearSearch (int [] vector, int key) {
        

    // }

    public static void main(String[] args) {
        
        Random r = new Random();

        int [] vector = buildVector(r.nextInt(8) + 8);

        int key = r.nextInt(31);

        showVector(vector);

        vector = organizingVector(vector);

        showVector(vector);
        

        System.out.println("O valor a ser pesquisado é: " + key + "\n");

        int valueIndex = linearSearch(vector, key);

        if (valueIndex == -1) {
            System.out.println("O valor pesquisado não está presente no seu vetor.");
        } else {
            System.out.println("O valor pesquisado está localizado na posição: " + (valueIndex + 1));
        }    
    }
}
