class Solution {
    public String trafficSignal(int timer) {
        if(timer == 0) return "Green";
        if(timer >30 && timer <=90 ) return "Red";

        return (timer==30)?"Orange":"Invalid";
    }
}