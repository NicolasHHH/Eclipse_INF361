
public class post5 {
	public static void triPorteur(int[] t){

        boolean perm = false;

        int j = 0;
        int count = 0;

        do{

            perm = false;

            j++;

            for(int i = 1; i < t.length; i++){

                System.out.print(i+":");
                for(int k = 0;k<4;k++) {
                	System.out.print(t[k]);
                }
                System.out.print("   ");

                if(t[i-1]>t[i]){
                	int temps = t[i];
                	t[i] = t[i-1];
                	t[i-1] = temps;
                	count ++;

                    perm = true;

                }

            }
            System.out.println(" j : "+j);

        } while(perm);
        System.out.println(count);

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {4,2,3,1};
		triPorteur(t);

	}

}
