/**
 * Created by Administrator on 2017/9/8.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class wb {

    private static String fileInPath = "D:/old2.txt";
    private static String fileOutPath = "D:/new.txt";

    public static void main(String[] args) throws Exception {
        // 读取原始文件
        FileInputStream fis = new FileInputStream(fileInPath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        // 创建新的文件
        FileOutputStream fos = new FileOutputStream(fileOutPath);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        String line = br.readLine();
        while (null != line && !"".equals(line.trim())) {
            StringBuffer tempLine = new StringBuffer();
            System.out.println(line);
            String[] lineArray = line.split(",");
            if (null == lineArray || lineArray.length == 0) {
                // 没有字符，什么都不做
            } else if (lineArray.length == 1) {
                // 如果等于1，则这一行只有一个字
                // 如：“aaa,工”，转为“aaa,工,0”
                bw.write(line + ",0");
                bw.flush();
            } else {
                // 其他情况
                // a,工,东,世
                // 转为如下所示
                // a,工,0
                // a,东,1
                // a,世,2
                for (int i = 0; i < lineArray.length - 1; i++) {
                    tempLine.append(lineArray[0] + "," + lineArray[i + 1] + "," + i + "\n");
                }
                bw.write(tempLine.toString());
                bw.flush();
            }
            line = br.readLine();
        }
        // 关闭相关流
    }

}
