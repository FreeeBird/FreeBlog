package cn.edu.hdu.blog.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class QiNiuUtil {

    @Value("${qiniu.access-key}")
    private String ACCESS_KEY;
    @Value(("${qiniu.secret-key}"))
    private String SECRET_KEY;
    @Value("${qiniu.bucket}")
    private String BUCKET_NAME;
    @Value("${qiniu.domain}")
    private String DOMAIN;

    public String getACCESS_KEY() {
        return ACCESS_KEY;
    }

    public String getSECRET_KEY() {
        return SECRET_KEY;
    }

    public String getBUCKET_NAME() {
        return BUCKET_NAME;
    }

    public String getDOMAIN() {
        return DOMAIN;
    }

    private UploadManager uploadManager;
    private BucketManager bucketManager;
    private Configuration cfg;
    private Client client;
    private Auth auth;

    public Client getClient(){
        if (client==null) {
            client=new Client(getConfiguration());
        }
        return client;
    }

    public BucketManager getBucketManager() {
        if (bucketManager == null) {
            bucketManager = new BucketManager(getAuth(), getConfiguration());
        }
        return bucketManager;
    }

    public UploadManager getUploadManager() {
        if (uploadManager == null) {
            uploadManager = new UploadManager(getConfiguration());
        }
        return uploadManager;
    }

    public Configuration getConfiguration() {
        if (cfg == null) {
            cfg = new Configuration(Region.region2());
        }
        return cfg;
    }

    public Auth getAuth() {
        if (auth == null) {
            auth = Auth.create(getACCESS_KEY(), getSECRET_KEY());
        }
        return auth;
    }

    public String getUpToken(){
        return getAuth().uploadToken(getBUCKET_NAME());
    }

    public String upload(InputStream inputStream,String fileKey) throws IOException{
        Response response;
        try {
            response = getUploadManager().put(inputStream,fileKey,
                    getUpToken(),null,null);
            return DOMAIN+"/"+fileKey;
        }catch (QiniuException e){
            response = e.response;
            e.printStackTrace();
            return "error";
        }
    }

}
