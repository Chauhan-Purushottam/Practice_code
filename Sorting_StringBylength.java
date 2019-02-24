
//Given Set of String sort the set according to the length of the string maintain the order if the length is same.
/*Input :
3
ab cd e j asd ljffg df
a a b b c c
xy yx zxy zx xzy xxx 

Output :

e j ab cd df asd ljffg 
a a b b c c 
xy yx zx zxy xzy xxx
*/

import java.util.*;

class Sorting_StringBylength {
        
    static class StringComparator  implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {      
            return o1.length()-o2.length();
        }
    
    }
    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        for(int i = 0;i<=n;i++)
        {
          
		    ArrayList<String> arr = new ArrayList<String>();
            String st = s.nextLine();
            String []str = st.split(" ");
            for(String a: str)
            {
                arr.add(a);
            }
            Collections.sort(arr,new StringComparator());
            for(String a: arr)
                System.out.print(a+" ");
         System.out.println(" ");
        }

    }
}
