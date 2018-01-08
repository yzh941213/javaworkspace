package com.zhezhuo.biz.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Shaka on 15/6/2.
 */
public class StrongRandom extends Random{
    static final long serialVersionUID = 4398490852824852845L;
    private Random random;

    private boolean weakRandom;

    protected final static String SESSION_ID_RANDOM_ALGORITHM = "SHA1PRNG";
    protected final static String SESSION_ID_RANDOM_ALGORITHM_ALT = "IBMSecureRandom";


    public StrongRandom() {
        try {
            // This operation may block on some systems with low entropy. See
            // this page
            // for workaround suggestions:
            // http://docs.codehaus.org/display/JETTY/Connectors+slow+to+startup
            random = SecureRandom.getInstance(SESSION_ID_RANDOM_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            try {
                random = SecureRandom.getInstance(SESSION_ID_RANDOM_ALGORITHM_ALT);
                weakRandom = false;
            } catch (NoSuchAlgorithmException e_alt) {
                random = new Random();
                weakRandom = true;
            }
        }

        random.setSeed(random.nextLong() ^ System.currentTimeMillis() ^ hashCode() ^ Runtime.getRuntime().freeMemory());
    }


    public boolean nextBoolean() {
        return random.nextBoolean();
    }


    public void nextBytes(byte[] bytes) {
        random.nextBytes(bytes);
    }


    public double nextDouble() {
        return random.nextDouble();
    }


    public float nextFloat() {
        return random.nextFloat();
    }


    public double nextGaussian() {
        return random.nextGaussian();
    }


    public int nextInt() {
        return random.nextInt();
    }


    public int nextInt(int n) {
        return random.nextInt(n);
    }


    public long nextLong() {
        if (weakRandom) {
            return Runtime.getRuntime().freeMemory() ^ System.currentTimeMillis() ^ random.nextLong();
        }
        return random.nextLong();
    }
}
