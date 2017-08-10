package com.zl.base.json;


public class Random {


    private Data intarray[]; 
    private Data chararray[]; 
    private Data intarray_dc[]; 
    private StringBuffer s1;// 保存产生的数字密码 
    private StringBuffer s2; 
    private StringBuffer s3;// 保存产生的数字和字母组合密码 

    public Random() 
    {
        intarray 	= new Data[10]; 
        intarray_dc = new Data[10]; 
        chararray 	= new Data[24]; 
        
        s1 = new StringBuffer(); //        
        s2 = new StringBuffer(); 
        s3 = new StringBuffer(); 
       
        s2.append("abcdefghijkmnpqrstuvwxyz"); //oOl  去掉的字符

        for (int i = 0; i < s2.length(); i++) 
        { 
            Data temp1 = new Data(s2.charAt(i), 0); 
            chararray[i] = temp1; 
        }
        for (int i = 0; i < 10; i++) 
        { 
            Data temp = new Data(i, 0); 
            intarray[i] = temp; 
            Data temp1 = new Data(i, 0); 
            intarray_dc[i] = temp1; 
        }
    } 
 
    /*** 
     * 产生数字组成的密码 
     *  
     * @param length  欲产生的密码长度 
     * @return 密码字符串(数字) 
     */ 
    public String GeneratePassworrd(int length) {
        while (s1.length() < length) 
        { 
            int t = (int) Math.floor(10 * Math.random()); 
            int k = s1.length() / 10; 
            if (intarray[t].Getcount() == k) 
            { 
                s1.append(intarray[t].Getnum());
                intarray[t].Setcou(k + 1); 
            } 
        } 
        return s1.toString(); 
    }
    /*** 
     * 产生数字和字母组成的密码 
     *  
     * @param length 欲产生的密码长度 
     * @return 密码字符串(数字和字母组合) 
     */ 
    /*** 
     * 产生数字和字母组成的密码 
     *  
     * @param length 欲产生的密码长度 
     * @return 密码字符串(数字和字母组合) 
     */ 
    public String GeneratePassworrd1(int length) 
    {
        while (s3.length() < length) 
        { 
            int t1 = (int) Math.floor(34 * Math.random()); 
            int k = s3.length() / 34; 
            if (t1 < 10 && intarray_dc[t1].Getcount() == k) 
            { 
                s3.append(intarray_dc[t1].Getnum()); 
                intarray_dc[t1].Setcou(k + 1); 
            } 
        } 
        return s3.toString(); 
    }
    
    
    
    /*** 
     * 产生数字和字母组成的密码 
     *  
     * @param length 欲产生的密码长度 
     * @return 密码字符串(数字和字母组合) 
     */ 
    public String GeneratePassworrd2(int length) 
    {
        while (s3.length() < length) 
        { 
            int t1 = (int) Math.floor(34 * Math.random()); 
            int k = s3.length() / 34; 
            if (t1 >= 10 && chararray[t1 - 10].Getcount() == k) 
            { 
                s3.append(chararray[t1 - 10].GetChar()); 
                chararray[t1 - 10].Setcou(k + 1); 
            } 
        }
        return s3.toString(); 
    }

    public String GeneratePassworrd3(int length) 
    {
        while (s3.length() < length) 
        { 
            int t1 = (int) Math.floor(34 * Math.random()); 
            int k = s3.length() /34; 
            if (t1 < 10 && intarray_dc[t1].Getcount() == k) 
            { 
                s3.append(intarray_dc[t1].Getnum()); 
                intarray_dc[t1].Setcou(k + 1); 
            } 
            else if (t1 >= 10 && chararray[t1 - 10].Getcount() == k) 
            { 
                s3.append(chararray[t1 - 10].GetChar()); 
                chararray[t1 - 10].Setcou(k + 1); 
            } 
        }
        return s3.toString(); 
    }
/**
 * 
 * @author Administrator
 *
 */
class Data { 
    public int num; 
    private int count; 
    private char su; 
 
    public Data(int i, int flag) { 
        num = i; 
        count = flag; 
    } 
 
    public Data(char c, int flag) { 
        su = c; 
        count = flag; 
    } 
 
    public void Setcou(int flag) { 
        count = flag; 
    } 
 
    public int Getnum() { 
        return num; 
    } 
 
    public char GetChar() { 
        return su; 
    } 
 
    public int Getcount() { 
        return count; 
    } 
}; 


    public String getSlhm(String date_type_str,int pwd_rand_length)
    {
    	 Random s1 = new Random(); 
         StringBuffer str_sum=new StringBuffer();
         str_sum.append(s1.GeneratePassworrd(pwd_rand_length));
         
        System.out.println(str_sum.toString());
         	//System.out.println(time.gettime("yyyyMMdd")+s.GeneratePassworrd2(2)); 
/*         Random s2 = new Random();
         str_sum.append(s2.GeneratePassworrd1(1));
         	//System.out.println(str_sum.toString()); 
         Random s3 = new Random(); 
         str_sum.append(s3.GeneratePassworrd3(3));*/
    	return time.gettime(date_type_str)+str_sum.toString();
    }


    public static void main(String[] args)
    {
/*        Random s1 = new Random();
        StringBuffer str_sum=new StringBuffer();
        str_sum.append(s1.GeneratePassworrd3(1));

        	//System.out.println(str_sum.toString());
        	//System.out.println(time.gettime("yyyyMMdd")+s.GeneratePassworrd2(2));
        Random s2 = new Random();
        str_sum.append(s2.GeneratePassworrd1(1));
        	//System.out.println(str_sum.toString());
        Random s3 = new Random();
        str_sum.append(s3.GeneratePassworrd3(1));
        	System.out.println(time.gettime("yyyyMMdd")+str_sum.toString()); */

        Random rd=new Random();
        Random s1 = new Random();
        StringBuffer str_sum=new StringBuffer();
        str_sum.append(s1.GeneratePassworrd(4));

        System.out.println(str_sum.toString());
        System.out.println(rd.getSlhm("yyMMdd",5));
/*         Random s2 = new Random();
         str_sum.append(s2.GeneratePassworrd1(1));
         	//System.out.println(str_sum.toString());
         Random s3 = new Random();
         str_sum.append(s3.GeneratePassworrd3(3));*/

    }
}
