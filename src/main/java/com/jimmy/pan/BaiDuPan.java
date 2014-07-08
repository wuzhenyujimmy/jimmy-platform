package com.jimmy.pan;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class BaiDuPan {
    private static final String ACCESS_KEY = "21.2d64f37b4542a1d9f8dc9dcbf9ea00cb.2592000.1407371058.3391459293-3087172";

    public void getPanInfo() {

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("method", "info");
        paramMap.put("access_token", ACCESS_KEY);

        HttpGet httpGet = getMethod("https://c.pcs.baidu.com/rest/2.0/pcs/quota", paramMap);
        
        HttpClient httpClient = new DefaultHttpClient();
        

        HttpResponse response;
        try {
            response = httpClient.execute(httpGet);

            // if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            // }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private HttpGet getMethod(String uri, Map<String, String> paramMap) {
        String params = getMethodParams(paramMap);
        System.out.println(uri + params);
        return new HttpGet(uri + params);
    }

    private String getMethodParams(Map<String, String> paramMap) {

        StringBuilder sb = new StringBuilder("?");

        for (String key : paramMap.keySet()) {
            sb.append(key).append("=").append(paramMap.get(key)).append("&");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private HttpPost postMethod(String uri, Map<String, String> paramMap) {
        HttpEntity entity = postMethodParams(paramMap);

        HttpPost post = new HttpPost(uri);
        post.setEntity(entity);

        return post;
    }

    private HttpEntity postMethodParams(Map<String, String> paramMap) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (String key : paramMap.keySet()) {
            params.add(new BasicNameValuePair(key, paramMap.get(key)));
        }
        try {
            return new UrlEncodedFormEntity(params, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void fileList() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("method", "list");
        paramMap.put("access_token", ACCESS_KEY);
        paramMap.put("path", "/");
        paramMap.put("by", "size");
        paramMap.put("order", "asc");
        paramMap.put("limit", "");

        HttpGet post = getMethod("https://pcs.baidu.com/rest/2.0/pcs/file", paramMap);

        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response;
        try {
            response = httpClient.execute(post);

            // if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
            // }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void downloadFile(String uri, String filePath) {

    }

    public static void main(String[] args) {
        BaiDuPan pan = new BaiDuPan();
        pan.fileList();
    }

}
