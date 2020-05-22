package com.bin.pojo;

import java.util.Arrays;

public class StuPhoto {
    private int id;
    private String name;
    private long size;
    private byte[] file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "StuPhoto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
