package com.aishidai.app.config;

import com.alibaba.druid.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Shaka on 15/6/2.
 */
public class UniqId {
//    private static final Logger log = Logger.getLogger(UniqId.class);
//    private static final String LogPrefix = LoggerPrefix.makeLogPrefix(UniqId.class);

    private static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static Map<Character, Integer> rDigits = new HashMap<Character, Integer>(16);
    static {
        for (int i = 0; i < digits.length; ++i) {
            rDigits.put(digits[i], i);
        }
    }

    private static UniqId me = new UniqId();
    private String hostAddr;
    private final Random random = new Random();
    private final static ThreadLocal<MessageDigest> mHasher = new ThreadLocal<MessageDigest>();
    private final UniqTimer timer = new UniqTimer();

//    private final ReentrantLock opLock = new ReentrantLock();


    private UniqId() {
        try {
            InetAddress addr = InetAddress.getLocalHost();

            this.hostAddr = addr.getHostAddress();
        }
        catch (IOException e) {
            this.hostAddr = String.valueOf(System.currentTimeMillis());
        }

        if (StringUtils.isEmpty(this.hostAddr) || "127.0.0.1".equals(this.hostAddr)) {
            this.hostAddr = String.valueOf(System.currentTimeMillis());
        }
    }


    /**
     * 获取UniqID实例
     *
     * @return UniqId
     */
    public static UniqId getInstance() {
        return me;
    }


    /**
     * 获得不会重复的毫秒数
     *
     * @return
     */
    public long getUniqTime() {
        return this.timer.getCurrentTime();
    }


    /**
     * 获得UniqId
     *
     * @return uniqTime-randomNum-hostAddr-threadId
     */
    public String getUniqID() {
        StringBuffer sb = new StringBuffer();
        long t = this.timer.getCurrentTime();

        sb.append(t);

        sb.append("-");

        sb.append(this.random.nextInt(8999) + 1000);

//        sb.append("-");
//        sb.append(this.hostAddr);

        sb.append("-");
        sb.append(Thread.currentThread().hashCode());

        return sb.toString();
    }


    /**
     * 获取MD5之后的uniqId string
     *
     * @return uniqId md5 string
     */
    public String getUniqIDHashString() {
        return this.hashString(this.getUniqID());
    }


    /**
     * 获取MD5之后的uniqId
     *
     * @return byte[16]
     */
    public byte[] getUniqIDHash() {
        return this.hash(this.getUniqID());
    }

    private static MessageDigest getHasher() {
        if (mHasher.get() != null) {
            return mHasher.get();
        } else {
            MessageDigest tempHasher = null;
            try {
                tempHasher = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException nex) {
                // FIXME shenxun: in this case , tempHasher will be null , then
                // all the other methods will throw NPE .
                tempHasher = null;
//                log.error(LogPrefix + "new MD5 Hasher error", nex);
            }
            mHasher.set(tempHasher);
        }
        return mHasher.get();
    }
    /**
     * 对字符串进行md5
     *
     * @param str
     * @return md5 byte[16]
     */
    public byte[] hash(String str) {
        try {
            byte[] bt = getHasher().digest(str.getBytes("UTF-8"));
            if (null == bt || bt.length != 16) {
                throw new IllegalArgumentException("md5 need");
            }
            return bt;
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException("unsupported utf-8 encoding", e);
        }
    }


    /**
     * 对二进制数据进行md5
     *
     * @param data
     * @return md5 byte[16]
     */
    public byte[] hash(byte[] data) {
        byte[] bt = getHasher().digest(data);
        if (null == bt || bt.length != 16) {
            throw new IllegalArgumentException("md5 need");
        }
        return bt;
    }


    /**
     * 对字符串进行md5 string
     *
     * @param str
     * @return md5 string
     */
    public String hashString(String str) {
        byte[] bt = this.hash(str);
        return this.bytes2string(bt);
    }


    /**
     * 对字节流进行md5 string
     *
     * @param str
     * @return md5 string
     */
    public String hashBytes(byte[] str) {
        byte[] bt = this.hash(str);
        return this.bytes2string(bt);
    }


    /**
     * 将一个字节数组转化为可见的字符串
     *
     * @param bt
     * @return
     */
    public String bytes2string(byte[] bt) {
        if (bt == null) {
            return null;
        }
        int l = bt.length;

        char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = digits[(0xF0 & bt[i]) >>> 4];
            out[j++] = digits[0x0F & bt[i]];
        }

//        if (log.isDebugEnabled()) {
//            log.debug(LogPrefix + "[hash]" + new String(out));
//        }

        return new String(out);
    }


    /**
     * 将字符串转换为bytes
     *
     * @param str
     * @return byte[]
     */
    public byte[] string2bytes(String str) {
        if (null == str) {
            throw new NullPointerException("参数不能为空");
        }
        if (str.length() != 32) {
            throw new IllegalArgumentException("字符串长度必须是32");
        }
        byte[] data = new byte[16];
        char[] chs = str.toCharArray();
        for (int i = 0; i < 16; ++i) {
            int h = rDigits.get(chs[i * 2]).intValue();
            int l = rDigits.get(chs[i * 2 + 1]).intValue();
            data[i] = (byte) ((h & 0x0F) << 4 | l & 0x0F);
        }
        return data;
    }

    /**
     * 实现不重复的时间
     *
     * @author dogun
     */
    private static class UniqTimer {
        private final AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());


        public long getCurrentTime() {
            return this.lastTime.incrementAndGet();
        }
    }
}
