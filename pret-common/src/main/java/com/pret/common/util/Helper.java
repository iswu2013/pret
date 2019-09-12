package com.pret.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings({"rawtypes", "unchecked", "restriction"})
public class Helper {

    private static final String URL_PARAM_CONNECT_FLAG = "&";

    /**
     * 判断字符串只能由数字 字母组成
     *
     * @param value
     * @return
     */
    public static boolean checkedValue(String value) {
        if (value == null) {
            return true;
        }
        return !value.matches("^[A-Za-z0-9]+$");
    }

    /**
     * 把一个日期转换为(pattern)格式 的字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String DTS(Date date, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static long getDateTime(int year, int month, int day, int hour, int minute, int second) {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            rightNow.setTime(
                    simpleDate.parse(year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rightNow.getTime().getTime();
    }

    public static long getDateTime(int year, int month, int day) {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
        try {
            rightNow.setTime(simpleDate.parse(year + "/" + month + "/" + day));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rightNow.getTime().getTime();
    }

    public static Date STD(String timeStr, String pattern) {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        try {
            rightNow.setTime(simpleDate.parse(timeStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rightNow.getTime();
    }

    public static Calendar getDateCalendar(Date date) {
        Calendar rightNow = Calendar.getInstance();
        try {
            rightNow.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // rightNow.get(Calendar.YEAR);
        // rightNow.get(Calendar.MONTH);
        // rightNow.get(Calendar.DAY_OF_MONTH);
        return rightNow;
    }

    public static int random(int min, int max) {
        return (int) ((max + 1 - min) * Math.random() + min);
    }

    public static double random(double min, double max) {
        return (max + 1 - min) * Math.random() + min;
    }

    /**
     * @param len
     * @return
     */
    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder();

        String[] arr = numericString(1, len);
        for (String string : arr) {
            sb.append(string);
        }

        return sb.toString();
    }

    public static int getNotSimple(int[] param, int len) {
        Random rand = new Random();
        for (int i = param.length; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = param[index];
            param[index] = param[i - 1];
            param[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 10 + param[i];
        }
        return result;
    }

    public static String[] numericString(int quantity, int length) {
        // 声明结果集长度
        String[] res = new String[quantity];
        // 开始生成数字串
        for (int i = 0; i < quantity; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < length; j++) {
                sb.append(new Random().nextInt(10));
            }
            // 生成一个数字串保存在结果集中
            res[i] = sb.toString();
            // 开始对比保存的数据
            for (int j = 0; j < i; j++) {
                // 取50%相似值
                int similarity = length / 2;
                char[] y = res[i].toCharArray();
                char[] t = res[j].toCharArray();
                for (int k = 0; k < y.length; k++) {
                    if (y[k] == t[k]) {
                        similarity--;
                    }
                }
                // 不符合相似值，下标缩进
                if (similarity <= 0) {
                    i--;
                    break;
                }
            }
        }
        return res;
    }

    public static List<String> URLPost(String strUrl, Map map) throws IOException {
        String content = "";
        content = getUrl(map);
        String totalURL = null;

        if (content == null || "".equals(content.trim())) {
            totalURL = strUrl;
        } else {
            if (strUrl.indexOf("?") == -1) {
                totalURL = strUrl + "?" + content;
            } else {
                totalURL = strUrl + "&" + content;
            }
        }

        URL url = new URL(totalURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setAllowUserInteraction(false);
        con.setUseCaches(false);
        con.setRequestMethod("POST");
        con.setConnectTimeout(5000);
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        List<String> result = new ArrayList<String>();
        if (con.getResponseCode() == 200) {
            BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            while (true) {
                String line = bin.readLine();
                if (line == null) {
                    break;
                } else {
                    result.add(line);
                }
            }
        }

        if (con != null) {
            con.disconnect();// 关闭连接
        }

        return (result);
    }

    public static List URLGet(String strUrl, Map map) throws Exception {
        String content = "";
        content = getUrl(map);
        String totalURL = null;

        if (content == null || "".equals(content.trim())) {
            totalURL = strUrl;
        } else {
            if (strUrl.indexOf("?") == -1) {
                totalURL = strUrl + "?" + content;
            } else {
                totalURL = strUrl + "&" + content;
            }
        }
        URL url = new URL(totalURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setAllowUserInteraction(false);
        con.setUseCaches(false);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        List result = new ArrayList();
        if (con.getResponseCode() == 200) {
            BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            while (true) {
                String line = bin.readLine();
                if (line == null) {
                    break;
                } else {
                    result.add(line);
                }
            }
        }

        if (con != null) {
            con.disconnect();// 关闭连接
        }

        return (result);
    }

    private static String getUrl(Map<String, String> map) {
        if (null == map || map.keySet().size() == 0) {
            return ("");
        }
        StringBuffer url = new StringBuffer();
        Set keys = map.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = String.valueOf(i.next());
            if (map.containsKey(key)) {
                Object val = map.get(key);
                String str = val != null ? val.toString() : "";
                // try {
                // str = URLEncoder.encode(str, "UTF-8");
                // } catch (UnsupportedEncodingException e) {
                // e.printStackTrace();
                // }
                url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);
            }
        }
        String strURL = "";
        strURL = url.toString();
        if (URL_PARAM_CONNECT_FLAG.equals("" + strURL.charAt(strURL.length() - 1))) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }
        return (strURL);
    }

    public static String getWebRoot() throws RuntimeException {
        String path = getWebClassesPath();
        if (path.indexOf("WEB-INF") > 0) {
            path = path.substring(0, path.indexOf("WEB-INF") - 1);
        } else {
            throw new RuntimeException("路径获取错误");
        }
        return path;
    }

    private static String getWebClassesPath() {
        String path = Helper.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        return path;
    }

    /**
     * 获取配置文件内容
     *
     * @param propertiesName
     * @param key
     * @return
     */
    public static String getPropertiesValue(String propertiesName, String key) {
        ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
        String str = rb.getString(key);
        rb = null;
        try {
            return new String(str.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 本周开始时间
     *
     * @return
     */
    public static Date getNowWeekStartTime() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (Date) currentDate.getTime().clone();
    }

    /**
     * 本周结束时间
     *
     * @return
     */
    public static Date getNowWeekEndTime() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return (Date) currentDate.getTime().clone();
    }

    public static String base64Encoder(String str) {
        return new String(new BASE64Encoder().encode(str.getBytes()));
    }

    public static String base64Decoder(String str) throws IOException {
        return new String(new BASE64Decoder().decodeBuffer(str));
    }

    /**
     * 检测手机号码
     *
     * @param value
     * @return
     */
    public static boolean checkPhoneNum(String value) {
        if (value == null) {
            return false;
        }
        return value.matches("^[1][3-8]\\d{9}$");
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 发送邮件
     *
     * @param email
     * @param title
     * @param content
     * @throws MessagingException
     */
    public static void sendEmail(String email, String title, String content) throws MessagingException {

        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        /*
         * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
         * mail.user / mail.from
         */
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        // 发件人的账号
        props.put("mail.user", "i.emlovetyforever@gmail.com");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "lovezxx1314");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress to = new InternetAddress(email);
        message.setRecipient(RecipientType.TO, to);

        /*
         * // 设置抄送 InternetAddress cc = new InternetAddress("test@yeah.net");
         * goods.setRecipient(RecipientType.CC, cc); // 设置密送，其他的收件人不能看到密送的邮件地址
         * InternetAddress bcc = new InternetAddress("test@163.com");
         * goods.setRecipient(RecipientType.CC, bcc);
         */

        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件的内容体
        message.setContent(content + "<br/><br/><a href='http://www.pert.com'>pert</a>", "text/html;charset=UTF-8");

        // 发送邮件
        Transport.send(message);
    }

    /**
     * 四舍五入小数点
     *
     * @param f
     * @param newScale
     * @return
     */
    public static float doubleNewScale(float f, int newScale) {
        BigDecimal b = new BigDecimal(f);
        float f1 = b.setScale(newScale, BigDecimal.ROUND_HALF_UP).floatValue();
        return f1;
    }

    /**
     * java生成随机数字和字母组合
     *
     * @param
     * @return
     */
    public static String getCharAndNumr(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 获取Class属性
     *
     * @param c
     * @return
     */
    public static List<String> findClassFieldNames(Class<?> c) {
        List<String> classFieldNames = new ArrayList<String>();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            classFieldNames.add(field.getName());
        }
        return classFieldNames;
    }

    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {

        // 解析结果存储在HashMap
        Map<String, String> map = new HashMap<String, String>();
        InputStream inputStream = request.getInputStream();

        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }

        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;

    }
}
