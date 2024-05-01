package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class ItemUrls {

   @SerializedName("url_type")
   String urlType;

   @SerializedName("url_path")
   String urlPath;

   @SerializedName("document_id")
   String documentId;


    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }
    public String getUrlType() {
        return urlType;
    }
    
    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
    public String getUrlPath() {
        return urlPath;
    }
    
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getDocumentId() {
        return documentId;
    }
    
}