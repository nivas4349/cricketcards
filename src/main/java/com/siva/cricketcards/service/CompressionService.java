package com.siva.cricketcards.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@Component
@Slf4j
public class CompressionService {

    public byte[] compressString(String s) {
        if(StringUtils.isEmpty(s)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = null;
        try {
            gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gzipOutputStream.write(s.getBytes());
            gzipOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.warn("Unable to compress", e);
        }finally {
            if(gzipOutputStream != null){
                try {
                    gzipOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s.getBytes();
    }

    public String decompress(byte[] bytes) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream in = null;
        try {
            in = new GZIPInputStream(new ByteArrayInputStream(bytes));
            byte[] buffer = new byte[8192];
            int len;
            while((len = in.read(buffer))>0)
                baos.write(buffer, 0, len);
            return new String(baos.toByteArray());
        } catch (IOException e) {
            log.warn("Unable to decompress", e);
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    log.warn("Unable to decompress", e);
                }
            }
        }
        return new String(bytes);
    }
}
