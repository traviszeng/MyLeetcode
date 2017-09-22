/**
 * Created by Travis Zeng on 2017/9/22
 * */


/**
 *  There are 1000 buckets, one and only one of them contains poison, the rest are filled with water.
 *  They all look the same. If a pig drinks that poison it will die within 15 minutes.
 *  What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

 Answer this question, and write an algorithm for the follow-up general case.

 Follow-up:

 If there are n buckets and a pig drinking poison will die within m minutes,
 how many pigs (x) you need to figure out the "poison" bucket within p minutes? T
 here is exact one bucket with poison.
 * */

//solution
/**
 * For given minutesToDie and minutesToTest, with the clarification above, the only thing that matters here is the number of tests allowed T = (int)(minutesToTest/minutesToDie) because of the "cool down" restriction. Then the problem is translated equivalently to:

 How many states can we generate with x pigs and T tests to cover N scenarios?

 The number of states is exactly (T+1)^x and here is why. For each pig during T tests, it has exactly T+1 states: dies at some test#i (1<=i<=T) or still alive eventually. For x pigs, obviously the maximum possible number of states we could have is (T+1)^x since each pig's well-being solely depends on whether it ever fed on poison bucket and nothing to do with other pigs. So all we need to do is to

 find minimum x such that (T+1)^x >= N, which means x = ceil(logN/log(T+1)).

 Now we have the optimal candidate, but can we actually implement a feeding solution to achieve that optimum solution? Sure, here it is:

 Label buckets as a (T+1)-based number represented as x-dimensional vector v = (v[1], v[2], ...,v[x]) consecutively ascending from (0,0,...0). (each 0<=v[j]<=T)
 For each Test#i (1<=i<=T), if all pigs are dead by now, process is finished. Otherwise, for each pigj alive, feed it on all buckets with v[j] = i simultaneously, and record its death time D[j] = i if it dies after this test.
 Default D[j] = 0 if pigj is still alive after all T tests.

 Then we claim that: bucket with label (D[1],D[2],...,D[x]) must be the poison one.

 Because for each pigj, by design of Step 2, it is guaranteed to be alive before feeding on bucket (D[1],D[2],...,D[x]) and all those pigs which have ever fed on this bucket died right after that test.
 * */

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets)/Math.log(minutesToTest/minutesToDie+1));
    }

    public static void main(String[] args) {
        System.out.println(new PoorPigs().poorPigs(1000,15,60));
    }
}
