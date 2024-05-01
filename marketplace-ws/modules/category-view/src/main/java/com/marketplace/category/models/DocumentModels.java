package com.marketplace.category.models;

// for the document related operation we create a document model
public class DocumentModels {

	private String uploadedDocName;
	private String downloadDocumentLink;
	private String fileEntryId;
	
	public String getUploadedDocName() {
		return uploadedDocName;
	}
	public void setUploadedDocName(String uploadedDocName) {
		this.uploadedDocName = uploadedDocName;
	}
	public String getDownloadDocumentLink() {
		return downloadDocumentLink;
	}
	public void setDownloadDocumentLink(String downloadDocumentLink) {
		this.downloadDocumentLink = downloadDocumentLink;
	}
	public String getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(String fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	
	@Override
	public String toString() {
		return "DocumentModel [uploadedDocName=" + uploadedDocName + ", downloadDocumentLink=" + downloadDocumentLink
				+ ", fileEntryId=" + fileEntryId + "]";
	}
	
}
