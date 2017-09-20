/**
 * Created by Travis Zeng on 2017/5/1.
 */

/**
 *  Count the number of prime numbers less than a non-negative number, n.
 *
 * */

/**
 * chuanbindeng 的 素数判断算法

 关于素数的算法是信息学竞赛和程序设计竞赛中常考的数论知识，在这里我跟大家讲一下寻找一定范围内素数的几个算法。看了以后相信

 对大家一定有帮助。

 正如大家都知道的那样，一个数 n 如果是合数，那么它的所有的因子不超过sqrt(n)--n的开方,那么我们可以用这个性质用最直观的方法

 来求出小于等于n的所有的素数。

 num = 0;

 for(i=2; i<=n; i++)

 {  for(j=2; j<=sqrt(i); j++)

 if( j%i==0 ) break;

 if( j>sqrt(i) ) prime[num++] = i;  //这个prime[]是int型，跟下面讲的不同。

 }

 这就是最一般的求解n以内素数的算法。复杂度是o(n*sqrt(n))，如果n很小的话，这种算法（其实这是不是算法我都怀疑，没有水平。当然没

 接触过程序竞赛之前我也只会这一种求n以内素数的方法。-_-~）不会耗时很多.

 但是当n很大的时候，比如n=10000000时，n*sqrt(n)>30000000000,数量级相当大。在一般的机子它不是一秒钟跑不出结果，它是好几分钟都跑不

 出结果，这可不是我瞎掰的，想锻炼耐心的同学不妨试一试~。。。。

 在程序设计竞赛中就必须要设计出一种更好的算法要求能在几秒钟甚至一秒钟之内找出n以内的所有素数。于是就有了素数筛法。

 （我表达得不清楚的话不要骂我，见到我的时候扁我一顿我不说一句话。。。）

 素数筛法是这样的：

 1.开一个大的bool型数组prime[]，大小就是n+1就可以了.先把所有的下标为奇数的标为true,下标为偶数的标为false.

 2.然后：

 for( i=3; i<=sqrt(n); i+=2 )

 {   if(prime[i])

 for( j=i+i; j<=n; j+=i ) prime[j]=false;

 }

 3.最后输出bool数组中的值为true的单元的下标，就是所求的n以内的素数了。

 原理很简单，就是当i是质(素)数的时候，i的所有的倍数必然是合数。如果i已经被判断不是质数了，那么再找到i后面的质数来把这个质

 数的倍数筛掉。

 一个简单的筛素数的过程：n=30。

 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30



 第 1 步过后2 4 ... 28 30这15个单元被标成false,其余为true。

 第 2 步开始：

 i=3;  由于prime[3]=true, 把prime[6], [9], [12], [15], [18], [21], [24], [27], [30]标为false.

 i=4;  由于prime[4]=false,不在继续筛法步骤。

 i=5;  由于prime[5]=true, 把prime[10],[15],[20],[25],[30]标为false.

 i=6>sqrt(30)算法结束。

 第 3 步把prime[]值为true的下标输出来：

 for(i=2; i<=30; i++)

 if(prime[i]) printf("%d ",i);

 结果是 2 3 5 7 11 13 17 19 23 29


 * */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n < 3)
            return 0;

        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(499979));
    }
}
