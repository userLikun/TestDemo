package com.ane.testdemo.retrofit;

import java.io.Serializable;

/**
 *
 * 时间 2016/4/12 0012.
 */
public class HttpParams implements Serializable {
    private static final long serialVersionUID = 4759881344802429790L;
    //参数
    private String params;
    //时间戳
    private long timestamp;
    //摘要
    private String digest;
    //类型
    private String type;/**
     * 扫描数据参数
     */
    private byte[] scanParams;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getScanParams() {
        return scanParams;
    }

    public void setScanParams(byte[] scanParams) {
        this.scanParams = scanParams;
    }

    public String getDigest() {
        return digest;
    }

    @Override
    public String toString() {
        return "HttpParams{" +
                "params='" + params + '\'' +
                ", timestamp=" + timestamp +
                ", digest='" + digest + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
