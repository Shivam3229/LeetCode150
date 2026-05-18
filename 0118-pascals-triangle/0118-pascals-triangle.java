// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> result = new ArrayList<>();
     
//           for (int i = 0; i < numRows; i++) {
           
//             List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
//             // filled the particular row with 1

        
//             for (int j = 1; j < i; j++) {
//                 // updates the value except first and last with the sum of the previous ones
               
//                 row.set(j, result.get(i - 1).get(j - 1) +
//                            result.get(i - 1).get(j));
//             }

//             result.add(row);

//         }

//         return result;
//     }
// }
class Solution {
    public List<Integer> genrateRow(int r){
        int ans=1;
        List<Integer> ansRow =new ArrayList();
        ansRow.add(1);
        for(int c=1;c<r;c++){
            ans=ans*(r-c);
            ans=ans/c;
            ansRow.add(ans);
        }
        return ansRow;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>triangle =new ArrayList();
           for (int i = 1; i <= numRows; i++) {
                 triangle.add(genrateRow(i));  
            }
        return triangle;
    }
}