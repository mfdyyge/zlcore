/**
 * Created by Administrator on 2017/9/24.
 */

import java.util.Random;
public class StrBuilder_Test {


    public static void main(String[] args) {
        test();
    }

    //
    public static void test() {
        //
        int allLen = 8000000;
        int subLen = 11;
        int charLen = 4;
        String cl = buildString(charLen);
        int times = 50;
        //
        testMatch(allLen, subLen, cl, times);
    }

    public static void testMatch(int allLen, int subLen, String cl,  int times){
        int allBF = 0;
        int allString = 0;
        int allKMP = 0;
        int allGC = 0;
        int allbuild = 0;
        int alltoArray = 0;

        long start = System.currentTimeMillis();

        System.out.println("--------------------------");
        for (int i = 0; i < times; i++) {
            // 1. 构造字符串的损耗
            long buildStart = System.currentTimeMillis();
            String sub = buildString(subLen, cl);
            String all = buildString(allLen, sub) +sub;
            long buildEnd = System.currentTimeMillis();
            allbuild += (buildEnd - buildStart);
            // 2. toCharArray的损耗
            long toArrayStart = System.currentTimeMillis();
            char[] allArray = all.toCharArray();
            char[] subArray = sub.toCharArray();
            long toArrayEnd = System.currentTimeMillis();
            alltoArray += (toArrayEnd - toArrayStart);
            //
            long startBF = System.currentTimeMillis();
            int indexBF = bfIndexOf(all, sub);
            long endBF = System.currentTimeMillis();
            //
            long timeoutBF = endBF - startBF;
            allBF += timeoutBF;
            System.gc();
            allGC += (System.currentTimeMillis() - endBF);

            //
            long startString = System.currentTimeMillis();
            int indexString = stringIndexOf(all, sub);
            long endString = System.currentTimeMillis();
            //
            long timeoutString = endString - startString;
            allString += timeoutString;
            System.gc();
            allGC += (System.currentTimeMillis() - endString);


            //
            long startKMP = System.currentTimeMillis();
            //int indexKMP = kmpIndexOf(all, sub);
            int indexKMP = KMP_Index(allArray, subArray);
            long endKMP = System.currentTimeMillis();
            //
            long timeoutKMP = endKMP - startKMP;
            allKMP += timeoutKMP;
            System.gc();
            allGC += (System.currentTimeMillis() - endKMP);

            //
            //System.out.println("all="+all.substring(0,100)+" ......");
            //System.out.println("sub="+sub);
            //
            //System.out.println("indexBF="+indexBF+";耗时: "+timeoutBF+"ms");
            //System.out.println("indexString="+indexString+";耗时: "+timeoutString+"ms");
            if(indexBF == indexString && indexKMP == indexString){
                //System.out.println("!!!!对比相等。");
            } else {
                throw new RuntimeException("对比出错.");
            }

            //
            if(i % 20 == 10){
                System.out.println(i+"次bfIndexOf= "+allBF+"ms");
                System.out.println(i+"次stringIndexOf= "+allString+"ms");
                System.out.println(i+"次KMPIndexOf= "+allKMP+"ms");
                System.out.println(i+"次allbuild= "+allbuild+"ms");
                System.out.println(i+"次alltoArray= "+alltoArray+"ms");
                System.out.println(i+"*3次,GC= "+allGC+"ms");
                long end = System.currentTimeMillis();
                long allTime = end-start;
                long lossTime = allTime - (allBF+allString+allKMP+allGC);
                System.out.println(i+"次,所有总计耗时: "+(allTime)+"ms; 损耗:" + lossTime +"ms; 损耗比: " +((0.0+lossTime)/allTime * 100)+"%");
                System.out.println("--------------------------");
            }

        }
        //
        System.out.println(times+"次bfIndexOf;总计耗时: "+allBF+"ms");
        System.out.println(times+"次stringIndexOf;总计耗时: "+allString+"ms");
        System.out.println(times+"次KMPIndexOf;总计耗时: "+allKMP+"ms");
        System.out.println(times+"次allbuild= "+allbuild+"ms");
        System.out.println(times+"次alltoArray= "+alltoArray+"ms");
        System.out.println(times+"*3次,GC;总计耗时: "+allGC+"ms");
        long end = System.currentTimeMillis();
        long allTime = end-start;
        long lossTime = allTime - (allBF+allString+allKMP+allGC);
        System.out.println(times+"次,所有总计耗时: "+(allTime)+"ms; 损耗:" + lossTime +"ms; 损耗比: " +((0.0+lossTime)/allTime * 100)+"%");
        System.out.println("--------------------------");

    }

    //


    // 构建字符

    public static String buildString(int len){
        return buildString(len, null);
    }
    public static String buildString(int len, String sub){
        //
        final int TYPE_NUMBER = 0;
        final int TYPE_LOWERCASE = 1;
        final int TYPE_UPPERCASE = 2;
        //
        long seed = System.nanoTime();
        Random random = new Random(seed);
        //
        //
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            //
            int type = random.nextInt(3);// 0-2
            int cvalue = 0;
            if(TYPE_NUMBER == type){
                cvalue = '0' + random.nextInt(10);// 0~(n-1)
            } else if(TYPE_LOWERCASE == type){
                cvalue = 'a' + random.nextInt(26);// 0~(n-1)
            } else if(TYPE_UPPERCASE == type){
                cvalue = 'A' + random.nextInt(26);// 0~(n-1)
            } else {
                throw new RuntimeException(Random.class.getName()+"#newxtInt(int);Wrong!");
            }
            //
            //cvalue = 'A' + random.nextInt(26);// 0~(n-1)
            //
            char c = (char)cvalue;
            if(null != sub && sub.length() > 1){
                int index = random.nextInt(sub.length());
                c = sub.charAt(index);
            }
            //String s = String.valueOf(c);
            builder.append(c);
            //
        }
        //
        return builder.toString();
    }




    /**
     * Java自带的方法,内部实现了
     * @param all
     * @param sub
     * @return
     */
    public static int stringIndexOf(String all, String sub){
        // 防御式编程
        if(null == all || null== sub){
            return -1;
        }
        // 调用Java的String方法
        return all.indexOf(sub);
    }


    /**
     * BF算法
     * @param all
     * @param sub
     * @return
     */
    public static int bfIndexOf(String all, String sub){
        // 防御式编程
        if(null == all || null== sub){
            return -1;
        }
        //
        int lenAll = all.length();
        int lenSub = sub.length();
        int i = 0;
        while (i < lenAll) {
            // 从i下标开始对比
            int j = 0;
            while (j < lenSub) {
                //
                char all_i = all.charAt(i);
                char sub_j = sub.charAt(j);
                if(all_i == sub_j){
                    // 相等则继续对比下一个字符
                    i++;
                    j++; // 这个增长很重要
                } else {
                    // 否则跳出内层循环
                    break;
                }
            }
            // 如果 j 增长到和 lenSub相等,则匹配成功
            if(lenSub == j){
                return i - lenSub;
            } else {
                i = 1+i - j; // 回溯 i
            }
        }
        //
        return -1;
    }


    /**
     * KMP 算法
     * @param all
     * @param sub
     * @return
     */
    public static int kmpIndexOf(String all, String sub){
        //
        char[] allArray = all.toCharArray();
        char[] subArray = sub.toCharArray();
        //
        return KMP_Index(allArray, subArray);
    }
    /**
     * 获得字符串的next函数值
     *
     * @param t
     *            字符串
     * @return next函数值
     */
    public static int[] next(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {
                i++;
                j++;
                if (t[i] != t[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * KMP匹配字符串
     *
     * @param allArray
     *            主串
     * @param subArray
     *            模式串
     * @return 若匹配成功，返回下标，否则返回-1
     */
    public static int KMP_Index(char[] allArray, char[] subArray) {
        int[] next = next(subArray);
        int i = 0;
        int j = 0;
        while (i <= allArray.length - 1 && j <= subArray.length - 1) {
            if (j == -1 || allArray[i] == subArray[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < subArray.length) {
            return -1;
        } else
            return i - subArray.length; // 返回模式串在主串中的头下标
    }
}
