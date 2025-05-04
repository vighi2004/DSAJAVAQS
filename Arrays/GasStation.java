//finding gas sation(index) where we complete circle without any less gas or cost Using brute force.
public class GasStation {
        public static int solve(int gas[],int cost[]){
            for(int i=0;i<gas.length;i++){
                int index=i;
                int steps=0;
                int currGas=0;
                int j=i;
                while(steps<gas.length){
                    currGas += gas[j];
                    if(currGas<cost[j]){
                        break;
                    }
                    currGas -= cost[j];
                    j=(j+1)%gas.length;
                    steps++;
                }
                if(steps==gas.length){
                    return index;
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            int gas[]={3,9};
            int cost[]={7,6};
            System.out.println("At index:"+solve(gas,cost));
        }    
}
