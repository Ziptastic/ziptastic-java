/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipjava.ziptastic.java;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 *
 * @author bzfra_000
 */
public class Ziptastic {
    
    private final static String apikey = "88ad38789b858209141ac5699250d7370d5f1861";
    private final static String url = "https://zip.getziptastic.com/v3/US/42701/";
    
    public static String zipCall() throws IOException{
        
        String getData;
        
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
             
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("x-key", apikey);
             
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                System.out.println(entity.toString());
                getData = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
                
            }
        }
        return getData;
    }

    public static void main(String[] args) throws IOException{
        System.out.println(zipCall());
    }
}
