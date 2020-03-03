package com.minigod.common.odps.po;

import java.io.Serializable;

public class Pair implements Serializable {
    private static final long serialVersionUID = -7538164528624184614L;
    private Object key;
    private Object value;

    public Pair() {
    }

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return this.key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
