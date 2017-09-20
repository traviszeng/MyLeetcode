import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * Created by TravisZeng on 2017/3/13.
 */
/**
 * 计算文件md5
 * */

public class CalculateFileMD5 {
    public static String getFileMD5(File file){
        if(!file.isFile()) {
            return null;
        } else {
            MessageDigest digest = null;
            FileInputStream in = null;
            byte[] buffer = new byte[1024];

            Object var6;
            try {
                digest = MessageDigest.getInstance("MD5");
                in = new FileInputStream(file);

                int len;
                while((len = in.read(buffer, 0, 1024)) != -1) {
                    digest.update(buffer, 0, len);
                }

                in.close();
                return encodeHex(digest.digest());
            } catch (Exception var16) {
                var6 = null;
            } finally {
                Object buffer1 = null;

                try {
                    if(in != null) {
                        in.close();
                    }
                } catch (IOException var15) {
                    var15.printStackTrace();
                }

            }

            return (String)var6;
        }

    }

    public static String encodeHex(byte[] data) {
        if(data == null) {
            return null;
        } else {
            String HEXES = "0123456789abcdef";
            int len = data.length;
            StringBuilder hex = new StringBuilder(len * 2);

            for(int i = 0; i < len; ++i) {
                hex.append("0123456789abcdef".charAt((data[i] & 240) >>> 4));
                hex.append("0123456789abcdef".charAt(data[i] & 15));
            }

            return hex.toString();
        }
    }


    public static void main(String[] args) {
        String md51=CalculateFileMD5.getFileMD5(new File("D:\\用户目录\\下载\\caidao-20160620-www.maicaidao.com-master\\caidao-20160620-www.maicaidao.com.7z"));
        String md52="75F9C0EA9CE2BA266560FE3364127AE3".toLowerCase();
        System.out.println(md51.equals(md52));
    }
}