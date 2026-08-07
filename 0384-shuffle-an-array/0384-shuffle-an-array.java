class Solution { 
        private int[] original;
        private Random random;

        public Solution(int[] nums){
            original = nums.clone();
            random = new Random();
        }
        public int[] reset(){
            return original.clone();
        }
        public int[] shuffle(){
            int[] shuffled = original.clone();
            for(int i = shuffled.length - 1; i > 0; i--){
                int index = random.nextInt(i + 1);

                int temp = shuffled[i];
                shuffled[i] = shuffled[index];
                shuffled[index] = temp;
            }
            return shuffled;
        }
    }