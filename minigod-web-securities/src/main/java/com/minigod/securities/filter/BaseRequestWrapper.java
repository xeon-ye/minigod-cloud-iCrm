package com.minigod.securities.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.minigod.common.constant.Const;
import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;
    private String language;

    public BaseRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        body = IOUtils.toByteArray(request.getInputStream());
        language = request.getHeader(Const.H5_LANGUAGE_KEY);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    public byte[] getBody() {
        return body;
    }

    public void updateParams() {
        String json = new String(body);

        if (!json.contains("\"params\"")) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        String newJson = null;

        try {
            // 将 json 转成 JsonNode 对象
            JsonNode rootNode = mapper.readTree(json);
            // 得到节点值
            JsonNode params = rootNode.get("params");
            // 创建新节点
            ObjectNode newParams = mapper.createObjectNode();
            newParams.setAll((ObjectNode) params);
            newParams.put("langKey", language);

            // 创建新节点
            ObjectNode newNode = mapper.createObjectNode();
            newNode.setAll((ObjectNode) rootNode);
            newNode.set("params", newParams);

            // 将 JsonNode 对象转成 json
            newJson = mapper.writeValueAsString(newNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        body = newJson.getBytes();

    }

    /**
     * 在使用@RequestBody注解的时候，其实框架是调用了getInputStream()方法，所以我们要重写这个方法
     *
     * @return
     * @throws IOException
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    private String getData(String json) {
        if (!json.contains("\"params\"")) {
            return "";
        }
        ObjectMapper mapper = new ObjectMapper();
        String data = null;
        try {
            JsonNode jsonNode = mapper.readTree(json);
            data = jsonNode.get("params").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}