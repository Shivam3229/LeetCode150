class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int match = 0;

        int i = 0, j = 0;
        while (i < players.length && j < trainers.length) {
            if (trainers[j] < players[i]) {
                j++;
            }else if (trainers[j] >= players[i]) {
                match++;
                i++;j++;
            }
        }
        return match;
    }
}